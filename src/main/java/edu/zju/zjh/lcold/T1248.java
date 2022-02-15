package edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        ArrayList<Integer> odds = new ArrayList<>();

        odds.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odds.add(i);
            }
        }
        odds.add(nums.length);

        for (int j = 1; j + k < odds.size(); j++) {
            res += (odds.get(j) - odds.get(j - 1)) *
                    (odds.get(j + k) - odds.get(j + k - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 1, 1};
        int k = 3;

        T1248 t1248 = new T1248();
        System.out.println(t1248.numberOfSubarrays(nums, k));
    }
}
