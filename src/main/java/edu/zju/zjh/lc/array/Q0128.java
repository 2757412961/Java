package edu.zju.zjh.lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/5/31 10:32
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0128 {

    /**
     * 方法一：哈希表
     * 执行耗时:19 ms,击败了50.53% 的Java用户
     * 内存消耗:58 MB,击败了13.39% 的Java用户
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        // 把nums数据放入到列表中，有则置换为1
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 遍历，判断是否命中，命中则往两边看扩展，然后置换为0
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                int l = nums[i], r = nums[i] + 1, len = 0;
                while (set.contains(l)) {
                    len++;
                    set.remove(l--);
                }
                while (set.contains(r)) {
                    len++;
                    set.remove(r++);
                }

                res = Math.max(res, len);
            }
        }

        return res;
    }

}
