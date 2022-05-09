package edu.zju.zjh.lc.array.nsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/5/8 14:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
