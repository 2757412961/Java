package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/9 上午 12:45
 * @Modified_By :
 */
public class T039 {
    List<List<Integer>> res = new ArrayList<>();

    public void digui(int[] nums, int pos, int target, int sum, ArrayList<Integer> ans) {
        if (sum == target)
            res.add(new ArrayList<>(ans));

        for (int i = pos; i < nums.length; i++) {
            if (sum + nums[i] > target) break;
            ans.add(nums[i]);
            digui(nums, i, target, sum + nums[i], ans);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        digui(candidates, 0, target, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
//        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//
//        示例 1：
//        输入：candidates = [2,3,6,7], target = 7,
//                所求解集为：
//        [
//          [7],
//          [2,2,3]
//        ]
//
//        示例 2：
//        输入：candidates = [2,3,5], target = 8,
//                所求解集为：
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]

        int[] candidates = new int[]{2, 3, 5};
        int target = 8;

        System.out.println(new T039().combinationSum(candidates, target));
    }
}
