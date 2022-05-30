package edu.zju.zjh.lc.greddy;

/**
 * @author: zjh
 * @date : 2022/5/30 10:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0055 {

    /**
     * 贪心算法 O(n)
     * <p>
     * 执行耗时:2 ms,击败了94.33% 的Java用户
     * 内存消耗:42 MB,击败了20.15% 的Java用户
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        int idx = 0;

        while (idx < nums.length && idx <= max) {
            max = Math.max(max, idx + nums[idx]);
            idx++;
        }

        return max >= nums.length - 1;
    }

}
