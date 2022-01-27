package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/21 上午 10:31
 * @Modified_By :
 */
public class C5440 {
    public int xorOperation(int n, int start) {
        int res = start;

        for (int i = 1; i < n; i++) {
            res ^= (start + 2 * i);
        }

        return res;
    }

    public static void main(String[] args) {
//        示例 1：//
//        输入：n = 5, start = 0
//        输出：8
//        解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
//        "^" 为按位异或 XOR 运算符。

//        示例 2：//
//        输入：n = 4, start = 3
//        输出：8
//        解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.

        int n = 1;
        int start = 3;

        System.out.println(new C5440().xorOperation(n, start));
    }
}
