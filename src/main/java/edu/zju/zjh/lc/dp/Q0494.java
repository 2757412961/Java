package edu.zju.zjh.lc.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/11 下午 07:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0494 {

    /**
     * 回溯
     */
    private int res;

    public void findTargetSumWays0(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            if (target == 0) {
                res++;
            }
            return;
        }

        findTargetSumWays0(nums, idx + 1, target + nums[idx]);
        findTargetSumWays0(nums, idx + 1, target - nums[idx]);
    }

    public int findTargetSumWays0(int[] nums, int target) {
        findTargetSumWays0(nums, 0, target);
        return res;
    }

    /**
     * 备忘录
     */
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int idx, int target) {
        String key = idx + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (idx == nums.length) {
            if (target == 0) {
                memo.put(key, 1);
                return 1;
            } else {
                memo.put(key, 0);
                return 0;
            }
        }

        int x = findTargetSumWays(nums, idx + 1, target + nums[idx]);
        int y = findTargetSumWays(nums, idx + 1, target - nums[idx]);
        memo.put(key, x + y);

        return x + y;
    }

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return findTargetSumWays(nums, 0, target);
    }

    public static void main(String[] args) {
        System.out.println(new Q0494().findTargetSumWays0(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Q0494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
