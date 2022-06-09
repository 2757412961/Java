package edu.zju.zjh.lc.dp;

import java.util.List;

/**
 * @author: zjh
 * @date : 2022/6/9 14:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0120 {

    /**
     * 转数组+动态
     * 执行耗时:3 ms,击败了77.79% 的Java用户
     * 内存消耗:41.3 MB,击败了7.05% 的Java用户
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int n = triangle.size();

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int val = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + val;
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }

    /**
     * 执行耗时:7 ms,击败了12.10% 的Java用户
     * 内存消耗:41.1 MB,击败了44.43% 的Java用户
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            int min;
            for (int j = 0; j < cur.size(); j++) {
                int x = j - 1, y = j;
                min = Integer.MAX_VALUE;

                if (0 <= x) {
                    min = Math.min(min, cur.get(j) + prev.get(x));
                }
                if (y < prev.size()) {
                    min = Math.min(min, cur.get(j) + prev.get(y));
                }
                cur.set(j, min);
            }
        }

        for (Integer val : triangle.get(triangle.size() - 1)) {
            res = Math.min(res, val);
        }

        return res;
    }

}
