package main.java.edu.zju.zjh.lcold;

public class T042 {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int sleft = 0, sright = 0;

        int maxH = 0;
        for (int i = 0; i < n; i++) {
            maxH = Math.max(height[i], maxH);
            res -= height[i];
        }
        res += maxH * n;

        for (int h = maxH; h > 0; h--) {
            for (int i = 0; i < n; i++) {
                if (h <= height[i]) {
                    break;
                }
                sleft += 1;
            }
        }

        for (int h = maxH; h > 0; h--) {
            for (int j = n - 1; j >= 0; j--) {
                if (h <= height[j]) {
                    break;
                }
                sright += 1;
            }
        }

        return res - sleft - sright;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        T042 t042 = new T042();
        System.out.println(t042.trap(height));
    }
}
