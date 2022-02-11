package main.java.edu.zju.zjh.lcold;

import java.util.*;

public class T040 {
    Set<List<Integer>> res;
    int[] cans;
    int targ;
    int n;

    public void digui(ArrayList<Integer> lst, int sum, int i) {
        if (sum == targ && !res.contains(lst)) {
            res.add((ArrayList<Integer>) lst.clone());
            return;
        } else if (sum > targ) {
            return;
        }

        for (; i < n; i++) {
            lst.add(cans[i]);
            digui(lst, sum + cans[i], i + 1);
            lst.remove(lst.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2_20200910(int[] candidates, int target) {
        res = new HashSet<>();
        cans = candidates;
        targ = target;
        n = candidates.length;
        Arrays.sort(candidates);

        ArrayList<Integer> lst = new ArrayList<>();
        digui(lst, 0, 0);

        List<List<Integer>> res2 = new ArrayList<>();

        for (List<Integer> s : res) {
            res2.add(s);
        }

        return res2;
    }


    public void addSum(int[] nums, int target, int pos, int sum, List<Integer> ans, Set<List<Integer>> set) {
        if (sum == target) set.add(new ArrayList<>(ans));

        for (int i = pos; i < nums.length; i++) {
            if (sum + nums[i] > target) break;

            ans.add(nums[i]);
            addSum(nums, target, i + 1, sum + nums[i], ans, set);
            ans.remove(ans.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(candidates);
        addSum(candidates, target, 0, 0, ans, set);

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

//        [
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]

        System.out.println(new T040().combinationSum2(candidates, target));
        System.out.println(new T040().combinationSum2_20200910(candidates, target));
    }
}
