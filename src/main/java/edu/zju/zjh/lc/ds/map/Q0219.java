package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/18 14:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Object ConObecjt = new Object();
        Map<Integer, Object> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                map.remove(nums[i - k - 1]);
            }
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], ConObecjt);
        }

        return false;
    }

}
