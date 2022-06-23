package edu.zju.zjh.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/22 下午 04:27
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0448 {

    /**
     * 新建数组
     * 行耗时:3 ms,击败了99.69% 的Java用户
     * 内存消耗:49.2 MB,击败了63.26% 的Java用户
     */
    private class S1 {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            int[] used = new int[n + 1];
            List<Integer> store = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                used[nums[i]] = 1;
            }

            for (int i = 1; i <= n; i++) {
                if (used[i] == 0) {
                    store.add(i);
                }
            }

            return store;
        }

    }

    /**
     * 交换数组元素
     * 执行耗时:5 ms,击败了51.91% 的Java用户
     * 内存消耗:49.1 MB,击败了70.79% 的Java用户
     */
    private class S2 {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[nums[i] - 1] != nums[i]) {
                    int t = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = t;
                    i--;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i + 1 != nums[i]) {
                    res.add(i + 1);
                }
            }

            return res;
        }

    }

}
