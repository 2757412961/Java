package edu.zju.zjh.lcold;

public class T1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int s = 0, gs = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                s += customers[i];
            }
        }

        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                gs += customers[i];
            }
        }
        res = Math.max(res, gs);

        for (int i = X; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                gs += customers[i];
            }
            if (grumpy[i - X] == 1) {
                gs -= customers[i - X];
            }

            res = Math.max(res, gs);
        }

        res += s;
        return res;
    }

    public static void main(String[] args) {
//        示例：
//        输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//        输出：16
//        解释：
//        书店老板在最后 3 分钟保持冷静。
//        感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.

        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        System.out.println(new T1052().maxSatisfied(customers, grumpy, X));
    }
}
