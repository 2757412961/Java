package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T046 {
    int[] numss;
    List<List<Integer>> res = new ArrayList<>();

    public void dg(int[] used, int depth, Integer[] outs) {
        if (depth == used.length) {
            res.add(new ArrayList<Integer>(Arrays.asList(outs)));
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

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        Integer[] outs = new Integer[nums.length];
        numss = nums;

        dg(used, 0, outs);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        new T046().permute(nums);
    }
}
