package edu.zju.lemon.company.美团;

import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/3/19 上午 10:03
 * @Email : 2757412961@qq.com
 * @update:
 */
public class Q001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] c = new int[m];
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            d[i] = in.nextInt();
        }

        ////////////////////
        StringBuilder res = new StringBuilder();
        int sumPrice = 0;
        int zkSum = 0;
        int mjSum = 0;
        int maxmj = 0, point = 0;

        for (int i = 0; i < n; i++) {
            sumPrice += a[i];
            zkSum += b[i];

            maxmj = 0;
            for (int j = 0; j < m; j++) {
                if (sumPrice < c[j]) break;
                if (d[j] > maxmj) maxmj = d[j];
            }

            /// ...
            mjSum = sumPrice - maxmj;
            // 写你的判断
            if (mjSum == zkSum) res.append('B');
            else if (mjSum < zkSum) res.append('M');
            else if (mjSum > zkSum) res.append('Z');
        }


//        System.out.println(new Q001().bzm(n, y, z, m, c, d));
//        System.out.println("BZM");
        System.out.println(res.toString());
    }

}
