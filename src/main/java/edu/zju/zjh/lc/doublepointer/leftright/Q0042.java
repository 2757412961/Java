package edu.zju.zjh.lc.doublepointer.leftright;

public class Q0042 {

    public int trap0(int[] height) {
        int n = height.length;
        int[] maxl = new int[n], maxr = new int[n];
        int max, res = 0;

        max = 0;
        for (int i = 0; i < n; i++) {
            maxl[i] = max;
            if (height[i] > max) max = height[i];
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxr[i] = max;
            if (height[i] > max) max = height[i];
        }

        for (int i = 0; i < n; i++) {
            int trapi = Math.min(maxl[i], maxr[i]) - height[i];
            if (trapi > 0) {
                res += trapi;
            }
        }

        return res;
    }

    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1, maxl = 0, maxr = 0;

        while (left < right) {
            maxl = Math.max(maxl, height[left]);
            maxr = Math.max(maxr, height[right]);
            if (maxl < maxr) {
                res += maxl - height[left];
                left++;
            } else if (maxl > maxr) {
                res += maxr - height[right];
                right--;
            } else if (maxl == maxr) {
                res += maxr - height[right];
                right--;
            }
        }

        return res;
    }

}
