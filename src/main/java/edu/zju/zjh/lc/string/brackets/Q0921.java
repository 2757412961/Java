package edu.zju.zjh.lc.string.brackets;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/5/26 15:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0921 {

    /**
     * 方法一： 平衡法 时间复杂度： O(N)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了22.64% 的Java用户
     */
    public int minAddToMakeValid(String s) {
        int left = 0, loser = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    loser++;
                } else {
                    left--;
                }
            }
        }

        return left + loser;
    }

}
