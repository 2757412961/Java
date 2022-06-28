package edu.zju.zjh.lc.doublepointer;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/6/28 19:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1385 {

    /**
     * 方法一：模拟
     */
    private class S1 {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int cnt = 0;
            for (int x : arr1) {
                boolean ok = true;
                for (int y : arr2) {
                    ok &= Math.abs(x - y) > d;
                }
                cnt += ok ? 1 : 0;
            }
            return cnt;
        }
    }

    /**
     * 方法二：双指针法
     */

    private class S2 {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr1);  // O(nlogn)
            Arrays.sort(arr2); // O(mlogm)
            int i = 0, j = 0, len1 = arr1.length, len2 = arr2.length;
            int ans = 0;
            // 双指针 最坏O(n + m)
            while (i < len1 && j < len2) {
                while (j < len2 && arr2[j] < arr1[i]) j++;
                if ((j - 1 < 0 || Math.abs(arr1[i] - arr2[j - 1]) > d) && (j >= len2 || Math.abs(arr1[i] - arr2[j]) > d)) {
                    ans++;
                }
                i++;
            }
            // System.out.println(i + " " + j);
            // arr2 提前结束, 说明arr2最后一个元素比arr1[i]小
            while (i < len1 && arr1[i] - arr2[len2 - 1] <= d) {
                i++;
            }
            ans += len1 - i;
            return ans;
        }
    }

}
