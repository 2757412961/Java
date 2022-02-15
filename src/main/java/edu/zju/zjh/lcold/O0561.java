package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class O0561 {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1 && index <= 1) {
                res[index++] = key;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 4, 6};

        new O0561().singleNumbers(nums);
    }
}
