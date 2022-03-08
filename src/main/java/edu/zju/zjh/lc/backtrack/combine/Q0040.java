package edu.zju.zjh.lc.backtrack.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 15:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0040 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    private void backTrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);

        return res;
    }

}
