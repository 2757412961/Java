package edu.zju.zjh.topk.ali;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/10 15:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0093 {

    /**
     * 回溯
     * 执行耗时:1 ms,击败了95.25% 的Java用户
     * 内存消耗:40.1 MB,击败了85.38% 的Java用户
     */
    StringBuilder path = new StringBuilder();

    public void backTrack(List<String> res, String s, int idx, int level) {
        if (idx == s.length() && level == 0) {
            res.add(new String(path.substring(0, path.length() - 1)));
        }
        if (level == 0) return;
        if (s.length() < idx + level) return;

        if (idx < s.length()) {
            path.append(s.charAt(idx));
            path.append('.');
            backTrack(res, s, idx + 1, level - 1);
            path.deleteCharAt(path.length() - 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (idx + 1 < s.length() && s.charAt(idx) != '0') {
            path.append(s.charAt(idx));
            path.append(s.charAt(idx + 1));
            path.append('.');
            backTrack(res, s, idx + 2, level - 1);
            path.deleteCharAt(path.length() - 1);
            path.deleteCharAt(path.length() - 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (idx + 2 < s.length()) {
            int x = 0;
            x = x * 10 + s.charAt(idx) - '0';
            x = x * 10 + s.charAt(idx + 1) - '0';
            x = x * 10 + s.charAt(idx + 2) - '0';
            if (100 <= x && x <= 255) {
                path.append(s.charAt(idx));
                path.append(s.charAt(idx + 1));
                path.append(s.charAt(idx + 2));
                path.append('.');
                backTrack(res, s, idx + 3, level - 1);
                path.deleteCharAt(path.length() - 1);
                path.deleteCharAt(path.length() - 1);
                path.deleteCharAt(path.length() - 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();

        backTrack(res, s, 0, 4);
        return res;
    }

    public static void main(String[] args) {
        new Q0093().restoreIpAddresses("25253").stream().forEach(System.out::println);
        new Q0093().restoreIpAddresses("0000").stream().forEach(System.out::println);
    }

}
