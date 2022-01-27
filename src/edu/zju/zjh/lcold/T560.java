package edu.zju.zjh.lcold;

import java.util.HashMap;

public class T560 {
    public int subarraySum_violence(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }

        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 1};
        int k = 3;

        System.out.println(new T560().subarraySum(nums, k));
        System.out.println(new T560().subarraySum_violence(nums, k));
    }
}
