package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T078 {
    List<List<Integer>> res = new ArrayList<>();

    public void huishu(int[] nums, int pos, List<Integer> list) {
        if (pos >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        huishu(nums, pos + 1, new ArrayList<>(list));
        list.add(nums[pos]);
        huishu(nums, pos + 1, new ArrayList<>(list));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        huishu(nums, 0, new ArrayList<>());
        return res;
    }

    public void huishu2(int[] nums, int pos, List<Integer> list) {
        if (pos >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        huishu(nums, pos + 1, list);
        list.add(nums[pos]);
        huishu(nums, pos + 1, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
//        给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//        输入: nums = [1,2,3]
//        输出:
//        [
//          [3],
//          [1],
//          [2],
//          [1,2,3],
//          [1,3],
//          [2,3],
//          [1,2],
//          []
//        ]

        int[] nums = new int[]{1, 2, 3};

        System.out.println(new T078().subsets(nums));
    }
}
