package edu.zju.zjh.lc.backtrack.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 11:21
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0078 {

    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    private void backTrack(int[] nums, int start) {
        res.add(new LinkedList(path));

        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTrack(nums, 0);

        return res;
    }

}
