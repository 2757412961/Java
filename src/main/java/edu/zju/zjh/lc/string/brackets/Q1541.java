package edu.zju.zjh.lc.string.brackets;

/**
 * @author: zjh
 * @date : 2022/5/26 15:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1541 {

    /**
     * 简化版
     * 执行耗时:8 ms,击败了98.74% 的Java用户
     * 内存消耗:41.7 MB,击败了61.67% 的Java用户
     */
    public int minInsertions(String s) {
        char[] sc = s.toCharArray();
        int left = 0, rest = 0;
        int i = 0, n = sc.length;

        while (i < n) {
            char c = sc[i];
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    rest++;
                } else {
                    left--;
                }

                if (i < n - 1 && sc[i+1] == ')') {
                    i++;
                } else {
                    rest++;
                }
            }
            i++;
        }

        return left * 2 + rest;
    }

    /**
     * 复杂版
     * 执行耗时:8 ms,击败了98.74% 的Java用户
     * 内存消耗:41.9 MB,击败了30.36% 的Java用户
     */
    public int minInsertionsC(String s) {
        char[] sc = s.toCharArray();
        int left = 0, rest = 0;
        int i = 0, n = sc.length;

        while (i < n) {
            char c = sc[i];
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (i == n - 1) {
                    if (left == 0) {
                        rest += 2;
                    } else {
                        left--;
                        rest += 1;
                    }
                } else if (sc[i + 1] == ')') {
                    i++;
                    if (left == 0) {
                        rest += 1;
                    } else {
                        left--;
                    }
                } else if (sc[i + 1] == '(') {
                    if (left == 0) {
                        rest += 2;
                    } else {
                        left--;
                        rest += 1;
                    }
                }
            }
            i++;
        }

        return left * 2 + rest;
    }

}
