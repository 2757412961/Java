package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/5/31 15:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0136 {

    /**
     * 执行耗时:1 ms,击败了99.99% 的Java用户
     * 内存消耗:41.4 MB,击败了52.22% 的Java用户
     */
    public int singleNumber(int[] nums) {
        // 异或操作：
        // 相同的数字异或结果为0，5^5==0
        // 0和任何数字异或结果为数字，0^9==9
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

}
