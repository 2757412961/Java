package edu.zju.zjh.topk.ali;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/11 10:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0046 {

    LinkedList<Integer> path = new LinkedList<>();

    public void backTrack(List<List<Integer>> res, int[] nums, boolean[] vis, int idx) {
        if (idx == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path.offerLast(nums[i]);
                backTrack(res, nums, vis, idx + 1);
                path.pollLast();
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        backTrack(res, nums, vis, 0);

        return res;
    }

}
