package main.java.edu.zju.zjh.lcold;

public class T011 {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        int[] sortIndex = new int[n];
        int[] maxDis = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i] <= height[j]) {
                    maxDis[i] = Math.max(maxDis[i], Math.abs(i - j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxDis[i] * height[i]);
        }


        return res;
    }

    public int maxAreaDoblePointer(int[] height) {
        int res = 0;
        int n = height.length;
        int i = 0, j = n - 1;

        while (i < j) {
            res = Math.max(res, Math.abs(i - j) * Math.min(height[i], height[j]));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }


        return res;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        T011 t011 = new T011();
        System.out.println(t011.maxArea(height));
        System.out.println(t011.maxAreaDoblePointer(height));
    }
}
