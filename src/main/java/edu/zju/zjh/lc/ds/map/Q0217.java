package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/18 8:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0217 {

    public boolean containsDuplicate(int[] nums) {
        Object CONOBJECT = new Object();
        Map<Integer, Object> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], CONOBJECT);
        }

        return false;
    }

}
