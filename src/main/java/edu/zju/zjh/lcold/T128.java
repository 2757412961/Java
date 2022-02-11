package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        int n = nums.length;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], true);
        }

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            int key = entry.getKey();
            Boolean val = entry.getValue();

            int left = key, righ = key;
            if (val) {
                map.put(key, false);

                while (map.containsKey(--left)) {
                    map.put(left, false);
                }
                left++;

                while (map.containsKey(++righ)) {
                    map.put(righ, false);
                }
                righ--;
            }
            res = Math.max(res, righ - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 3, 200, 4, 1, 2};

        System.out.println(new T128().longestConsecutive(nums));
    }
}
