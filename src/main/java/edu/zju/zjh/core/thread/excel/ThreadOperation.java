package edu.zju.zjh.core.thread.excel;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: zjh
 * @date : 2022/4/27 15:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadOperation {

    // 发短信的同步等待时间
    private static final long SEND_COST_TIME = 100L;

    // 手机号文件
    private static final String FILE_NAME = "./phone_number.xlsx";

    // 手机号列表
    private static List<String> phoneList = new ArrayList<>();

    // 单例对象
    private static volatile ThreadOperation threadOperation;

    // 线程个数
    private static final int THREAD_POOL_SIZE = 10;

    // 初始化线程池
    private ExecutorService executorService = new ThreadPoolExecutor(
            THREAD_POOL_SIZE,
            THREAD_POOL_SIZE,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>()
    );

    public ThreadOperation() {
        // 获取classpath下资源的URL对象
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);
        String path = resource.getPath();
        // 从本地文件中读取手机号码
        readFromExcel(path);
    }

    /**
     * 单例获取对象
     *
     * @return
     */
    public static ThreadOperation getInstance() {
        if (threadOperation == null) {
            synchronized (ThreadOperation.class) {
                if (threadOperation == null) {
                    threadOperation = new ThreadOperation();
                }
            }
        }
        return threadOperation;
    }


    /**
     * Main
     */
    public static void main(String[] args) {
        ThreadOperation threadOperation = getInstance();
        //threadOperation.singleThread(phoneList);
        threadOperation.multiThreadSend(phoneList);
    }

    /**
     * 读取Excel的文件信息
     *
     * @param fileName
     */
    public static void readFromExcel(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int num = 0;
            // 循环行Row
            for (int rowNum = 0, lastNum = sheet.getLastRowNum(); rowNum <= lastNum; rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);
                String phoneNumber = getStringValueFromCell(row.getCell(0)).trim();
                phoneList.add(phoneNumber);
            }
            System.out.println(num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel里面Cell内容
     *
     * @param cell
     * @return
     */
    private static String getStringValueFromCell(XSSFCell cell) {
        if (cell == null) {
            return null;
        }

        // 单元格内的时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 单元格内的数字类型
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        // 单元格默认为空
        String cellValue = "";

        // 按类型读取
        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            // 日期转为时间形式
            if (DateUtil.isCellDateFormatted(cell)) {
                double d = cell.getNumericCellValue();
                Date date = DateUtil.getJavaDate(d);
                cellValue = dateFormat.format(date);
            } else {
                // 其他转为数字
                cellValue = decimalFormat.format((cell.getNumericCellValue()));
            }
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
            cellValue = "";
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            cellValue = String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
            cellValue = "";
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
            cellValue = cell.getCellFormula().toString();
        }
        return cellValue;
    }

    /**
     * 外部接口耗时长，通过多线程增强
     *
     * @param userPhone
     */
    public void sendMsgToPhone(String userPhone) {
        try {
            Thread.sleep(SEND_COST_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send message to : " + userPhone);
    }

    /**
     * 单线程发送
     *
     * @param phoneList
     * @return
     */
    private long singleThread(List<String> phoneList) {
        long start = System.currentTimeMillis();
        /*// 直接主线程执行
        for (String phoneNumber : phoneList) {
            threadOperation.sendMsgToPhone(phoneNumber);
        }*/
        SendMsgExtendThread smet = threadOperation.new SendMsgExtendThread(phoneList);
        smet.start();
        long totalTime = System.currentTimeMillis() - start;
        System.out.println("单线程发送总时间：" + totalTime);
        return totalTime;
    }

    /**
     * 另外一种分配方式
     *
     * @param phoneList
     */
    private void otherThread(List<String> phoneList) {
        for (int threadNo = 0; threadNo < 10; threadNo++) {
            int numbersPerThread = 10;
            List<String> list = phoneList.subList(threadNo * numbersPerThread, (threadNo * numbersPerThread) + 10);
            SendMsgExtendThread smet = threadOperation.new SendMsgExtendThread(list);
            smet.start();
            if (list.size() < numbersPerThread) {
                break;
            }
        }
    }

    /**
     * 两个线程发送
     *
     * @param phoneList
     * @return
     */
    private long twoThreads(List<String> phoneList) {
        long start = System.currentTimeMillis();
        List<String> list1 = phoneList.subList(0, phoneList.size() / 2);
        List<String> list2 = phoneList.subList(phoneList.size() / 2, phoneList.size());
        SendMsgExtendThread smet = threadOperation.new SendMsgExtendThread(list1);
        smet.start();
        SendMsgExtendThread smet1 = threadOperation.new SendMsgExtendThread(list2);
        smet1.start();
        return 0;
    }

    /**
     * 线程池发送
     *
     * @param phoneList
     * @return
     */
    private void threadPool(List<String> phoneList) {
        for (int threadNo = 0; threadNo < THREAD_POOL_SIZE; threadNo++) {
            int numbersPerThread = 10;
            List<String> list = phoneList.subList(threadNo * numbersPerThread, (threadNo * numbersPerThread) + 10);
            threadOperation.executorService.execute(threadOperation.new SendMsgExtendThread(list));
        }
        threadOperation.executorService.shutdown();
    }

    /**
     * 多线程发送
     *
     * @param phoneList
     * @return
     */
    private void multiThreadSend(List<String> phoneList) {
        List<Future<Long>> futures = new ArrayList<>();
        for (int threadNo = 0; threadNo < THREAD_POOL_SIZE; threadNo++) {
            int numbersPerThread = 100;
            List<String> list = phoneList.subList(threadNo * numbersPerThread, (threadNo * numbersPerThread) + 100);
            Future<Long> future = threadOperation.executorService.submit(threadOperation.new SendMsgImplCallable(list, String.valueOf(threadNo)));
            futures.add(future);
        }
        for (Future<Long> future : futures) {
            try {
                System.out.println("Time cost: " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadOperation.executorService.shutdown();
    }

    public class SendMsgExtendThread extends Thread {

        private List<String> numberListByThread;

        public SendMsgExtendThread(List<String> numberList) {
            numberListByThread = numberList;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numberListByThread.size(); i++) {
                System.out.print("no." + (i + 1));
                sendMsgToPhone(numberListByThread.get(i));
            }
            System.out.println("== single thread send " + numberListByThread.size() + "execute time:" + (System.currentTimeMillis() - startTime) + " ms");
        }
    }

    public class SendMsgImplCallable implements Callable<Long> {

        private List<String> numberListByThread;

        private String threadName;

        public SendMsgImplCallable(List<String> numberList, String threadName) {
            numberListByThread = numberList;
            this.threadName = threadName;
        }

        @Override
        public Long call() throws Exception {
            Long startMills = System.currentTimeMillis();
            for (String number : numberListByThread) {
                sendMsgToPhone(number);
            }
            Long endMills = System.currentTimeMillis();
            return endMills - startMills;
        }
    }
}

