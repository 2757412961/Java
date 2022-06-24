package edu.zju.zjh.lc.doublepointer;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/24 下午 02:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0443 {

    /**
     * 方法一：双指针
     * 执行耗时:1 ms,击败了91.05% 的Java用户
     * 内存消耗:41.4 MB,击败了6.30% 的Java用户
     */
    private class S1 {

        public int compress(char[] chars) {
            int l = 0, r = 0, count = 0;
            LinkedList<Character> stack = new LinkedList<>();

            for (int i = 0; i < chars.length; i++) {
                count++;
                if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                    chars[l++] = chars[i];
                    if (count != 1) {
                        while (count != 0) {
                            stack.push((char) (count % 10 + '0'));
                            count /= 10;
                        }
                        while (!stack.isEmpty()) {
                            chars[l++] = stack.pop();
                        }
                    }
                    count = 0;
                }
            }

            return l;
        }

    }

}
