package edu.zju.zjh.lc.ds.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/7/12 15:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0350 {

    /**
     * 方法一：哈希表
     * 执行耗时:1 ms,击败了98.89% 的Java用户
     * 内存消耗:41.2 MB,击败了93.45% 的Java用户
     */
    private class S1 {

        public int[] intersect(int[] nums1, int[] nums2) {
            int[] map = new int[1001];
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums1.length; i++) {
                map[nums1[i]]++;
            }

            for (int i = 0; i < nums2.length; i++) {
                if (map[nums2[i]] > 0) {
                    list.add(nums2[i]--);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }

            return res;
        }

    }

}
