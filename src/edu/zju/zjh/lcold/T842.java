package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T842 {
    String str;

    public int trans2i(int i, int j) {
        if (str.charAt(i) == '0' && j - i > 1) {
            return -1;
        }

        long result = Long.valueOf(str.substring(i, j));

        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }

    public int leni(int x) {
        int len = 0;

        do {
            len++;
            x /= 10;
        } while (x > 0);

        return len;
    }

    public Boolean isfib(int i, int j) {
        int a = trans2i(0, i);
        int b = trans2i(i, j);
        int k = j, n = str.length();

        while (k < n) {
            int c = a + b;
            int len = leni(c);

            if (k + len > n || a < 0 || b < 0 || c != trans2i(k, k + len)) {
                return false;
            }

            k += len;
            a = b;
            b = c;
        }

        return true;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        this.str = S;
        int n = S.length();
        int n2 = Math.min(10, n / 2 + 1);
        int n3 = n * 2 / 3 + 1;

        for (int i = 1; i < n2; i++) {
            for (int j = i + 1; j < n3 && j - i < 10; j++) {
                if (isfib(i, j)) {
                    int a = trans2i(0, i);
                    int b = trans2i(i, j);
                    int k = j;

                    res.add(a);
                    res.add(b);
                    while (k < n) {
                        int c = a + b;
                        a = b;
                        b = c;

                        k += leni(c);
                        res.add(c);
                    }

                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        String S = "1101111";
//        String S = "1235813";
//        String S = "0123";
//        String S = "1011";
//        String S = "0000";
//        String S = "74912134825162255812723932620170946950766784234934";
        String S = "98131550821532132082953615085698039313111501114243242539335396365964102995031666546726964970";
//        [98131,55082,153213,208295,361508,569803,931311,1501114,2432425,3933539,6365964,10299503,16665467,26964970]
        System.out.println(Arrays.toString(new T842().splitIntoFibonacci(S).toArray()));
    }
}
