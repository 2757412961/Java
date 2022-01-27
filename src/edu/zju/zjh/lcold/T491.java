package edu.zju.zjh.lcold;

import java.util.*;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/25 下午 01:40
 * @Modified_By :
 */
public class T491 {
    Map<String, Boolean> keys = new HashMap<>();
    Set<List<Integer>> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();

    public void huisu(int[] nums, int index, int last, ArrayList<Integer> ans, String code) {
        if (index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (num >= last) {
                ans.add(num);

                String key = code + '_' + num;
                if (ans.size() > 1 && !keys.containsKey(key)) {
                    res.add(new ArrayList<>(ans));
                    keys.put(key, true);
                }
                huisu(nums, i + 1, num, ans, key);

                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        huisu(nums, 0, -101, ans, "");

        return res;
    }


    public static void main(String[] args) {
//        给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//
//        示例:
//        输入: [4, 6, 7, 7]
//        输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//
//        说明:
//        给定数组的长度不会超过15。
//        数组中的整数范围是 [-100,100]。
//        给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

        int[] nums = new int[]{4, 6, 7, 7};

        new T491().findSubsequences(nums);
    }
}
