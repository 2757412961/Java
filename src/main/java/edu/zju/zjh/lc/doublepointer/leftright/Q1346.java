package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/7/11 14:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1346 {

    /**
     * 方法一：暴力法
     */

    /**
     * 方法二：排序 + 双指针
     */

    /**
     * 方法三：哈希表
     * 执行耗时:2 ms,击败了57.18% 的Java用户
     * 内存消耗:40.9 MB,击败了51.19% 的Java用户
     */
    private class S1 {

        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            boolean zero = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    if (zero) return true;
                    zero = true;
                } else {
                    set.add(2 * arr[i]);
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i])) {
                    return true;
                }
            }

            return false;
        }

    }

}
