package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/25 13:53
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0066 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int n = a.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * a[i - 1];
        }
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * a[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * suf[i];
        }

        return res;
    }

}
