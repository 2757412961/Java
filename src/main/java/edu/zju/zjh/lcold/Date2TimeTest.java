package main.java.edu.zju.zjh.lcold;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2TimeTest {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2004-12-16 17:24:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHH");
        Date date2014 = sdf.parse(dateStr);

        System.out.println(date2014.toString());
        System.out.println(date2014.getTime());
        System.out.println(date2014.toLocaleString());
//        System.out.println(date2014.toDateString());
        long digitTime = date2014.getTime();
        date2014.setTime(digitTime - 8 * 60 * 60 * 1000);
        System.out.println(date2014.toLocaleString());
        System.out.println(sdf.format(date2014));
        System.out.println(sdf2.format(date2014));


    }
}
