package edu.zju.zjh.lcold;

import java.io.IOException;

public class TRuntime_Argo {

    /* 获取当前JVM的内存信息，返回的值是 字节为单位 */
    public static void getFreeMemory() {
        // 获取可用的内存
        long value = Runtime.getRuntime().freeMemory();
        System.out.println("可用内存为：" + value / 1024 / 1024 + "MB");

        // 获取JVM的内存 总数量， 该值会不断的变化
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("全部内存为-Xms：" + (totalMemory / (double) 1024 / 1024) + "MB");

        // 获取jvm可以最大使用的内存值，如果没有被限制 返回Long.MAX_VALUE
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("最大可使用内存为-XmX：" + (maxMemory / (double) 1024 / 1024) + "MB");

    }

    public static void main(String[] args) {
        getFreeMemory();

        // 无论什么指令，都建议加上"cmd /c"，这是实际开发中常用的方式
        // 默认是不会弹出 cmd 面板的，如果希望它弹出时，则可以加上 "start" 参数
        String execProm = "cmd.exe /c start %s/%s %s";
        String execFilePath = "F:\\BGCArgo\\netCDF\\dist";
        String execFileName = "readnetCDF.exe";
        String dacFilePath = "F:\\BGCArgo\\netCDF\\data\\D1900722_001.nc";

        String[] envp = new String[]{
                "execFilePath=" + execFilePath,
                "execFileName=" + execFileName,
                "dacFilePath=" + dacFilePath
        };

        try {
//            Runtime.getRuntime().exec("calc");
            Runtime.getRuntime().exec(
                    String.format(execProm, execFilePath, execFileName, dacFilePath)
            );

//            Process process = Runtime.getRuntime().exec("cmd");
//            PrintWriter out = new PrintWriter(process.getOutputStream());
//            String cmd ; //你的cmd命令
//            InputStream is = process.getInputStream(); //cmd返回出来的bai信息
//            out.println(execProm); //输入du你的命令
//            out.flush(); //写到控制台

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finish program!");

    }
}
