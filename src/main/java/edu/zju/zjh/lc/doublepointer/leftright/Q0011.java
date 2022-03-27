package edu.zju.zjh.lc.doublepointer.leftright;

public class Q0011 {

    public int maxArea(int[] height) {
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

}
