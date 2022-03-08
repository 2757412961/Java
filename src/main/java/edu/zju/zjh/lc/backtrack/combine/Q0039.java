package edu.zju.zjh.lc.backtrack.combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 14:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0039 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    private void backTrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.addLast(candidates[i]);
                backTrack(candidates, target - candidates[i], i);
                path.removeLast();
            }
        }
    }

    private void backTrack1(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (start == candidates.length) {
            return;
        }

        if (target - candidates[start] >= 0) {
            path.addLast(candidates[start]);
            backTrack(candidates, target - candidates[start], start);
            path.removeLast();
        }
        backTrack(candidates, target, start + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);

        return res;
    }

}
