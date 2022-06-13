package edu.zju.zjh.lc.doublepointer.leftright;

public class Q0042 {

    private class S1 {

        public int trap(int[] height) {
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

    }

    private class S2 {

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

    /**
     * 执行耗时:1 ms,击败了73.96% 的Java用户
     * 内存消耗:42.1 MB,击败了32.05% 的Java用户
     */
    private class S3 {

        public int trap(int[] height) {
            int res = 0;
            int n = height.length;
            int[] lmax = new int[n];
            int[] rmax = new int[n];

            // record max left & right
            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
            }

            for (int i = 0; i < n; i++) {
                int min = Math.min(lmax[i], rmax[i]);
                if (height[i] < min) {
                    res += min - height[i];
                }
            }

            return res;
        }

    }

}
