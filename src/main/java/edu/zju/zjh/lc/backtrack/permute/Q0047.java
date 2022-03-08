package edu.zju.zjh.lc.backtrack.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 15:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0047 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    private void backTrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums);

        return res;
    }

}
