package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/5/18 16:33
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0006 {

    /**
     * 执行耗时:4 ms,击败了82.55% 的Java用户
     * 内存消耗:41.9 MB,击败了44.38% 的Java用户
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder res = new StringBuilder();
        StringBuilder[] sbs = new StringBuilder[numRows];
        int id = 0;
        int flag = -1;

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            sbs[id].append(s.charAt(i));
            if (id == 0 || id == numRows - 1) flag = -flag;
            id += flag;
        }

        for (int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q0006().convert("PAHNAPLSIIGYIR", 4));
    }

}
