package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/12 21:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0383 {

    /**
     * 方法一：字符统计
     * 执行耗时:3 ms,击败了34.68% 的Java用户
     * 内存消耗:41.7 MB,击败了47.54% 的Java用户
     */
    private class S1 {

        public boolean canConstruct(String ransomNote, String magazine) {
            int[] cs = new int[128];

            for (int i = 0; i < magazine.length(); i++) {
                cs[magazine.charAt(i)]++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                char c = ransomNote.charAt(i);

                if (cs[c] == 0) return false;
                cs[c]--;
            }

            return true;
        }

    }

}
