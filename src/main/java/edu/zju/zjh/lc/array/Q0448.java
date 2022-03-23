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
