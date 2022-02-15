package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> in = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];

            if (map.containsKey(num) && map.get(num) > 0) {
                in.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[in.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = in.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(new T350().intersect(nums1, nums2)));
    }
}
