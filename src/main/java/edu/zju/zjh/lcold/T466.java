package main.java.edu.zju.zjh.lcold;

public class T466 {
    public int gcd(int n1, int n2) {
        int a = n1, b = n2;
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int res = 0;
        char[] strs1 = s1.toCharArray();
        char[] strs2 = s2.toCharArray();



        return res;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        int n1 = 4, n2 = 2;

        T466 t466 = new T466();
        System.out.println(t466.getMaxRepetitions(s1, n1, s2, n2));
    }
}
