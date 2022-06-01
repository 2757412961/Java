package edu.zju.zjh.lc.doublepointer.leftright;

/**
 * @author: zjh
 * @date : 2022/6/1 9:18
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0344 {

    /**
     * 双指针
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:47.9 MB,击败了73.92% 的Java用户
     */
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char temp;

        while (l < r) {
            temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }

}
