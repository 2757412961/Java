package edu.zju.zjh.gof23.prototype;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video video01 = new Video("zjh01", date);
        Video video02 = (Video) video01.clone();

        System.out.println("======= video01 =======");
        System.out.println(video01);
        System.out.println(video01.hashCode());

        System.out.println("======= video02 =======");
        System.out.println(video02);
        System.out.println(video02.hashCode());

        System.out.println("======= video set =======");
        video01.setName("zj=02");
        date.setDate(22131236);
        System.out.println(video01);
        System.out.println(video02);


    }
}
