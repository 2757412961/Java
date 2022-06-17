package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/6/17 16:33
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0844 {

    /**
     * 方法一：重构字符串 空间复杂度：O(N+M)
     * 执行耗时:1 ms,击败了50.49% 的Java用户
     * 内存消耗:39.7 MB,击败了17.41% 的Java用户
     */
    private class S1 {

        public boolean backspaceCompare(String s, String t) {
            int i = 0, j = 0;
            StringBuilder sbs = new StringBuilder();
            StringBuilder sbt = new StringBuilder();

            while (i < s.length() || j < t.length()) {
                if (i < s.length()) {
                    final char cs = s.charAt(i++);
                    if (cs == '#') {
                        if (sbs.length() > 0) {
                            sbs.deleteCharAt(sbs.length() - 1);
                        }
                    } else {
                        sbs.append(cs);
                    }
                }
                if (j < t.length()) {
                    final char ct = t.charAt(j++);
                    if (ct == '#') {
                        if (sbt.length() > 0) {
                            sbt.deleteCharAt(sbt.length() - 1);
                        }
                    } else {
                        sbt.append(ct);
                    }
                }
            }

            return sbs.toString().equals(sbt.toString());
        }

    }

    /**
     * 方法二：双指针 空间复杂度：O(1)
     */

}
