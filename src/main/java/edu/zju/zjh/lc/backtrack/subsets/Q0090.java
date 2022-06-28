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

    /**
     * 回溯
     */
    private class S1 {

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

    /**
     * 二刷
     * 执行耗时:1 ms,击败了99.65% 的Java用户
     * 内存消耗:41.4 MB,击败了80.06% 的Java用户
     */
    private class S2 {

        private ArrayList<Integer> path;
        private List<List<Integer>> res;

        public void backTrack(int[] nums, int start) {
            res.add(new ArrayList<>(path));

            for (int i = start; i < nums.length; i++) {
                // 去重
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                path.add(nums[i]);
                backTrack(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int n = nums.length;
            path = new ArrayList<>(n);
            res = new ArrayList<>();

            Arrays.sort(nums);
            backTrack(nums, 0);

            return res;
        }

    }

}
