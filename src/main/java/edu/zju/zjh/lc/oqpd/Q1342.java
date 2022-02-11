package main.java.edu.zju.zjh.lc.oqpd;

public class Q1342 {

    public int numberOfSteps(int num) {
        int res = 0;

        while (num > 0) {
            if (num % 2 == 1) res++;
            num = num / 2;
            if (num==0)break;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q1342().numberOfSteps(14));
        System.out.println(new Q1342().numberOfSteps(8));
    }

}
