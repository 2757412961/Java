package edu.zju.zjh.lc.backtrack.permute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 11:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0046 {

    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    private boolean[] used;

    private void backTrack(int[] nums) {
        if (path.size() == nums.length){
            res.add(new LinkedList(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.addLast(nums[i]);
            backTrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        backTrack(nums);

        return res;
    }

}
