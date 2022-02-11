package main.java.edu.zju.zjh.lcold;

import java.util.*;

public class T047 {
    int[] numss;
    Set<ArrayList<Integer>> set = new HashSet<>();

    public void dg(int[] used, int depth, Integer[] outs) {
        if (depth == used.length) {
            set.add(new ArrayList<Integer>(Arrays.asList(outs)));
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                int[] copy_used = used.clone();
                Integer[] copy_outs = outs.clone();
                copy_used[i] = 1;
                copy_outs[depth] = numss[i];
                dg(copy_used, depth + 1, copy_outs);
            }
        }
    }

    public List<List<Integer>> permuteUnique_20200918(int[] nums) {
        int[] used = new int[nums.length];
        Integer[] outs = new Integer[nums.length];

        numss = nums;
        dg(used, 0, outs);
        List<List<Integer>> res = new ArrayList<>(set);

        return res;
    }

    public void quanpai(List<List<Integer>> res, List<Integer> lst, int[] nums, boolean[] used) {
        if (lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                lst.add(nums[i]);
                quanpai(res, lst, nums, used);
                lst.remove(lst.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        quanpai(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public static void main(String[] args) {
//        给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        示例:
//        输入: [1,1,2]
//        输出:
//        [
//          [1,1,2],
//          [1,2,1],
//          [2,1,1]
//        ]

        int[] nums = new int[]{1, 1, 2};

        System.out.println(new T047().permuteUnique(nums));
        System.out.println(new T047().permuteUnique_20200918(nums));
    }
}
