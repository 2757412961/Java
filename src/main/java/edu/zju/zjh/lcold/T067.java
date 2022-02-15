package edu.zju.zjh.lcold;

public class T067 {
    public String addBinary(String a, String b) {
        String res = "";
        int i = a.length();
        int j = b.length();
        int jinwei = 0;


        while (--i >= 0 && --j >= 0) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(j) - '0';

            res = (char) (x + y + jinwei) % 2 + res;
            jinwei = (x + y + jinwei) / 2;
        }

        while (i >= 0) {
            int x = a.charAt(i) - '0';

            res = (char) (x + jinwei) % 2 + res;
            jinwei = (x + jinwei) / 2;
            i--;
        }

        while (--j >= 0) {
            int y = b.charAt(j) - '0';

            res = (char) (y + jinwei) % 2 + res;
            jinwei = (y + jinwei) / 2;
        }

        if (jinwei > 0) {
            res = '1' + res;
        }

        return res;
    }

    public static void main(String[] args) {
        T067 t067 = new T067();
        System.out.println(t067.addBinary("1010", "1011"));
    }
}
