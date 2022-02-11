package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/23 上午 11:03
 * @Modified_By :
 */
public class T201 {
    public int rangeBitwiseAnd_violence(int m, int n) {
        int res = n;

        for (int i = m; i < n; i++) {
            res &= i;
        }
        return res;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        boolean is = true;
        ArrayList<Integer> am = new ArrayList<>();
        ArrayList<Integer> an = new ArrayList<>();

        while (!(m == 0 && n == 0)) {
            am.add(m % 2);
            an.add(n % 2);

            m /= 2;
            n /= 2;
        }

        for (int i = am.size() - 1; i >= 0; i--) {
            if (am.get(i) != an.get(i)) {
                is = false;
            }
            int wei = is ? am.get(i) : 0;

            res = res * 2 + wei;
        }

        return res;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 7;

        System.out.println(new T201().rangeBitwiseAnd(m, n));
        System.out.println(new T201().rangeBitwiseAnd_violence(m, n));
    }
}
