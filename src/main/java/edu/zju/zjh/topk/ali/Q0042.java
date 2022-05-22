package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/21 9:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0042 {

    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }

        return res;
    }

}
