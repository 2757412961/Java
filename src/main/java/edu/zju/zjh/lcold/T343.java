package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:20
 * @Modified_By :
 */
public class T343 {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[60];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
//        给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

//        示例 1:
//        输入: 2
//        输出: 1
//        解释: 2 = 1 + 1, 1 × 1 = 1。

//        示例 2:
//        输入: 10
//        输出: 36
//        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

//        说明: 你可以假设 n 不小于 2 且不大于 58。

//        int n = 2;
        int n = 10;

        System.out.println(new T343().integerBreak(n));
    }
}
