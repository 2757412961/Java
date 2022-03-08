package edu.zju.zjh.lc.backtrack.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 14:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0090 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    private void backTrack(int[] nums, int start) {
        res.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);

        return res;
    }

}
