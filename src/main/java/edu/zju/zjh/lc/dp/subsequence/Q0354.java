package edu.zju.zjh.lc.dp.subsequence;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/11 下午 02:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0354 {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, res = 1;
        int[] dp = new int[n];

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}
