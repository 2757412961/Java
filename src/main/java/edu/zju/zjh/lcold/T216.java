package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T216 {
    List<List<Integer>> res = new ArrayList<>();

    public void combSum(int[] nums, int k, int n, int pos, int sum, List<Integer> ans) {
        if (ans.size() == k && sum == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (ans.size() > k) break;
            if (sum + nums[i] > n) break;

            ans.add(nums[i]);
            combSum(nums, k, n, i + 1, sum + nums[i], ans);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        combSum(nums, k, n, 0, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
//        找出所有相加之和为 n 的 k 个数的组合。
//        组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//        说明：
//        所有数字都是正整数。
//        解集不能包含重复的组合。 
//
//        示例 1:
//        输入: k = 3, n = 7
//        输出: [[1,2,4]]
//
//        示例 2:
//        输入: k = 3, n = 9
//        输出: [[1,2,6], [1,3,5], [2,3,4]]

        int k = 3, n = 9;

        System.out.println(new T216().combinationSum3(k, n));
    }
}
