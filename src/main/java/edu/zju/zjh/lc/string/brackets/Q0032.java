package edu.zju.zjh.lc.string.brackets;

/**
 * @author: zjh
 * @date : 2022/5/26 14:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0032 {

    /**
     * 方法一：动态规划 时间复杂度： O(n)
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了6.24% 的Java用户
     * <p>
     * 我们定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度。我们将 dp 数组全部初始化为 0 。显然有效的子串一定以 ‘)’ 结尾，
     * 因此我们可以知道以 ‘(’ 结尾的子串对应的 dp 值必定为 0 ，我们只需要求解 ‘)’ 在 dp 数组中对应位置的值。
     */
    public int longestValidParenthesesDP(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] dp = new int[n];
        int res = 0;

        for (int i = 1; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                dp[i] = 0;
            } else if (c == ')') {
                if (cs[i - 1] == '(') {
                    dp[i] = dp[Math.max(i - 2, 0)] + 2;
                } else if (cs[i - 1] == ')') {
                    int corri = i - 1 - dp[i - 1];
                    if (corri >= 0 && cs[corri] == '(') {
                        dp[i] = dp[Math.max(corri - 1, 0)] + dp[i - 1] + 2;
                    } else {
                        dp[i] = 0;
                    }
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 方法二：栈 时间复杂度： O(n)
     */
    public int longestValidParenthesesStack(String s) {
        return -1;
    }


    /**
     * 方法三：计数器 left 和 right 时间复杂度： O(n)
     * 当 left 计数器比 right 计数器大时，我们将 left 和 right 计数器同时变回 0
     * 当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了98.71% 的Java用户
     */
    public int longestValidParentheses(String s) {
        int res = 0, left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
                if (left == right) {
                    res = Math.max(res, left);
                } else if (left < right) {
                    left = right = 0;
                }
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                left++;
                if (left == right) {
                    res = Math.max(res, left);
                } else if (left > right) {
                    left = right = 0;
                }
            }
        }

        return res * 2;
    }

}
