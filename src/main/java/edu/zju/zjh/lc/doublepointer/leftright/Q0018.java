package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0018 {

    public List<List<Integer>> twoSum(int[] nums, int l, int r, int target) {
        List<List<Integer>> res = new ArrayList<>();

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else if (sum == target) {
                List<Integer> one = new ArrayList<>();
                one.add(nums[l]);
                one.add(nums[r]);
                res.add(one);
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
        }

        return res;
    }

    public List<List<Integer>> nSum(int[] nums, int l, int r, int target, int level) {
        List<List<Integer>> res = new ArrayList<>();
        if (level < 2) return res;

        if (level == 2) {
            List<List<Integer>> twoSumList = twoSum(nums, l, r, target);
            res = twoSumList;
        } else if (level > 2) {
            for (int i = l; i < r; i++) {
                if (i > l && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> nSumList = nSum(nums, i + 1, r, target - nums[i], level - 1);
                int addVal = nums[i];
                for (int li = 0; li < nSumList.size(); li++) {
                    List<Integer> list = nSumList.get(li);
                    list.add(addVal);
                    res.add(list);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 0, nums.length - 1, target, 4);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums2 = new int[]{2, 2, 2, 2, 2};
        int[] nums3 = new int[]{1, 0, 1, 2, -1, -4, -1};
        int[] nums4 = new int[]{0, 0, 0, 0};

        new Q0018().fourSum(nums, 0).forEach(System.out::println);
        System.out.println();
        new Q0018().fourSum(nums2, 8).forEach(System.out::println);
        System.out.println();
        new Q0018().fourSum(nums3, 0).forEach(System.out::println);
        System.out.println();
        new Q0018().fourSum(nums4, 0).forEach(System.out::println);
        System.out.println();
    }

}
