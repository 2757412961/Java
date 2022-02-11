package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/5 下午 04:42
 * @Modified_By :
 */
public class T1344 {
    public double angleClock(int hour, int minutes) {
        double h = 360 / 12;
        double m = 360 / 60;

        double angh = h * hour + h * minutes / 60;
        double angm = m * minutes;

        angh %= 360;
        angm %= 360;

        double cha = 0;
        if (angm > angh) {
            cha = angm - angh;
        } else {
            cha = angh - angm;
        }


        return Math.min(cha, 360 - cha);
    }

    public static void main(String[] args) {
//        给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。

//        int hour = 12;
//        int min = 30;
//
//        int hour = 3;
//        int min = 15;
//
//        int hour = 4;
//        int min = 50;
//
        int hour = 1;
        int min = 57;

        System.out.println(new T1344().angleClock(hour, min));
    }
}
