package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/10 14:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0165 {

    /**
     * 字符串分割
     * 执行耗时:1 ms,击败了65.13% 的Java用户
     * 内存消耗:39.1 MB,击败了89.96% 的Java用户
     */
    public int compareVersionSplit(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        int i = 0, j = 0;
        int v1 = 0, v2 = 0;
        while (i < v1s.length || j < v2s.length) {
            if (i >= v1s.length) {
                v1 = 0;
            } else {
                v1 = Integer.parseInt(v1s[i++]);
            }
            if (j >= v2s.length) {
                v2 = 0;
            } else {
                v2 = Integer.parseInt(v2s[j++]);
            }

            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }

        return 0;
    }

    /**
     * 双指针
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了91.42% 的Java用户
     */
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        int i = 0, j = 0;

        while (i < m || j < n) {
            int x = 0;
            while (i < m) {
                char ch = version1.charAt(i++);
                if (ch == '.') break;
                x = x * 10 + ch - '0';
            }

            int y = 0;
            while (j < n) {
                char ch = version2.charAt(j++);
                if (ch == '.') break;
                y = y * 10 + ch - '0';
            }

            if (x > y) return 1;
            if (x < y) return -1;
        }

        return 0;
    }

}
