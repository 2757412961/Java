package main.java.edu.zju.zjh.lcold;

public class T375 {
    public int calculate(int low, int high) {
        if (low >= high)
            return 0;
        int minres = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }

        return minres;
    }

    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }


    public static void main(String[] args) {
        int n = 10;

        System.out.println(new T375().getMoneyAmount(n));
    }

}
