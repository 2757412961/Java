package edu.zju.zjh.lcold;

import java.util.Stack;

public class T084 {
    public int largestRectangleArea_violence(int[] heights) {
        int res = 0;
        int n = heights.length;
        int sta = -1, end = -1;

        for (int i = 0; i < n; i++) {
            int width = 1;
            int height = heights[i];

            sta = i;
            while (--sta >= 0 && heights[sta] >= heights[i]) {

            }
            sta++;

            end = i;
            while (++end <= n - 1 && heights[end] >= heights[i]) {

            }
            end--;

            width = end - sta + 1;
            res = Math.max(res, width * height);
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        if (n == 0) return 0;
        if (n == 1) return heights[0];

        int[] nheights = new int[n + 2];
        nheights[0] = 0;
        nheights[n + 1] = 0;
        for (int i = 0; i < n; i++) {
            nheights[i + 1] = heights[i];
        }

        stack.add(0);
        int top = -1, left, righ;
        for (int i = 1; i < n + 2; i++) {
            while (nheights[stack.peek()] > nheights[i]) {
                top = stack.pop();
                left = stack.peek();
                righ = i - 1;

                res = Math.max(res, (righ - left) * nheights[top]);
            }

            stack.push(i);
        }


        return res;
    }


    public static void main(String[] args) {
//        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int[] heights = new int[]{4, 2};


        System.out.println(new T084().largestRectangleArea(heights));
        System.out.println(new T084().largestRectangleArea_violence(heights));
    }
}
