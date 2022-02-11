package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/18 下午 10:15
 * @Modified_By :
 */
public class T097 {
    Boolean res = false;


    public void judge(String s1, String s2, String s3, int id1, int id2, int id3) {
        if (id3 >= s3.length()) {
            if (id1 == s1.length() && id2 == s2.length()) {
                res = true;
            }
            return;
        }
        char ch1 = '.';
        char ch2 = '.';
        char ch3 = '.';

        if (id1 < s1.length()) {
            ch1 = s1.charAt(id1);
        }
        if (id2 < s2.length()) {
            ch2 = s2.charAt(id2);
        }
        if (id3 < s3.length()) {
            ch3 = s3.charAt(id3);
        }

        if (ch1 == ch2 && ch2 == ch3) {
            judge(s1, s2, s3, id1 + 1, id2, id3 + 1);
            judge(s1, s2, s3, id1, id2 + 1, id3 + 1);
        } else if (ch1 == ch3) {
            judge(s1, s2, s3, id1 + 1, id2, id3 + 1);
        } else if (ch2 == ch3) {
            judge(s1, s2, s3, id1, id2 + 1, id3 + 1);
        }

    }


    public boolean isInterleave_violence(String s1, String s2, String s3) {
        judge(s1, s2, s3, 0, 0, 0);

        return res;
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        dp[0][0] = true;
        if (m + n != s3.length()) return false;

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = dp[i][0];
            } else {
                dp[i + 1][0] = false;
            }
        }

        for (int j = 0; j < n; j++) {
            if (s2.charAt(j) == s3.charAt(j)) {
                dp[0][j + 1] = dp[0][j];
            } else {
                dp[0][j + 1] = false;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                char ch3 = s3.charAt(i + j - 1);
                dp[i][j] = false;

                if (ch1 == ch3 && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (ch2 == ch3 && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
//        给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
//        示例 1:
//        输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//        输出: true
//
//        示例 2:
//        输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//        输出: false


//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";

        String s1 = "ab";
        String s2 = "bc";
        String s3 = "bcab";

        System.out.println(new T097().isInterleave(s1, s2, s3));
        System.out.println(new T097().isInterleave_violence(s1, s2, s3));
    }
}
