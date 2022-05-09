package edu.zju.zjh.lc.backtrack;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/5/8 16:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0022 {

    /**
     * 动态规划
     * 执行耗时:8 ms,击败了10.02% 的Java用户
     * 内存消耗:41.7 MB,击败了5.57% 的Java用户
     */
    public List<String> generateParenthesisDP(int n) {
        List<String>[] res = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = new LinkedList<>();
        }

        res[0].add("");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                List<String> left = res[j];
                List<String> right = res[i - 1 - j];
                for (String l : left) {
                    for (String r : right) {
                        res[i].add('(' + l + ')' + r);
                    }
                }
            }
        }

        return res[n];
    }

    /**
     * 回溯算法
     * 执行耗时:1 ms,击败了77.04% 的Java用户
     * 内存消耗:41.4 MB,击败了48.03% 的Java用户
     */
    private List<String> res = new LinkedList<>();
    private StringBuilder path = new StringBuilder();

    public void backTrack(int n, int leftNum, int rightNum) {
        if (leftNum < rightNum) return;
        if (leftNum > n || rightNum > n) return;
        if (leftNum == n && rightNum == n) {
            res.add(new String(path));
        }

        path.append('(');
        backTrack(n, leftNum + 1, rightNum);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        backTrack(n, leftNum, rightNum + 1);
        path.deleteCharAt(path.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        new Q0022().generateParenthesis(0).forEach(System.out::println);
        System.out.println();
        new Q0022().generateParenthesis(1).forEach(System.out::println);
        System.out.println();
        new Q0022().generateParenthesis(3).forEach(System.out::println);
        System.out.println();
        new Q0022().generateParenthesis(4).forEach(System.out::println);
        System.out.println();
//        new Q0022().generateParenthesis(8).forEach(System.out::println);
//        System.out.println();
    }

}
