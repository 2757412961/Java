package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/7 下午 08:53
 * @Modified_By :
 */
public class T044 {
    public boolean isMatch_official(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    public boolean match(String s, String p, int si, int pi) {
        if (pi >= p.length()) return si >= s.length();
        if (si >= s.length()) return p.charAt(pi) == '*' && match(s, p, si, pi + 1);

        if (p.charAt(pi) == '*') {
            return match(s, p, si + 1, pi) || match(s, p, si, pi + 1);
        }

        return (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) && match(s, p, si + 1, pi + 1);
    }

    public boolean isMatch_digui(String s, String p) {
        return match(s, p, 0, 0);
    }

    public static void main(String[] args) {
//        给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
//        '?' 可以匹配任何单个字符。
//        '*' 可以匹配任意字符串（包括空字符串）。
//        两个字符串完全匹配才算匹配成功。
//
//        说明:
//        s 可能为空，且只包含从 a-z 的小写字母。
//        p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。

//        String s = "aa";
//        String p = "*";
//        String s = "acdcb";
//        String p = "a*?b";
        String s = "adceb";
        String p = "*a*b";

//        String s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
//        String p = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";

        System.out.println(new T044().isMatch_digui(s, p));
        System.out.println(new T044().isMatch_official(s, p));
    }
}
