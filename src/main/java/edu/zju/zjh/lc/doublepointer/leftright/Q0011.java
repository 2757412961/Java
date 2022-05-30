package edu.zju.zjh.lc.doublepointer.leftright;

public class Q0011 {

    public int maxArea1(int[] height) {
        int res = -1;
        int n = height.length, left = 0, right = n - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else if (height[left] == height[right]) {
                // same for any side
                right--;
            }
        }

        return res;
    }

    /**
     * 二刷
     * 贪心算法 O(n)
     * 执行耗时:4 ms,击败了67.02% 的Java用户
     * 内存消耗:51.8 MB,击败了8.32% 的Java用户
     */
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            // 舍弃不可能成为容器边界的值
            if (height[l] < height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r++;
            } else if (height[l] == height[r]) {
                // 1 7 3 6 7
                // 1 7 3 8 7
                l++;
            }
        }

        return res;
    }

}
