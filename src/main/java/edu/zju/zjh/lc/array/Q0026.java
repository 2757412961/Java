package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/6 15:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0026 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了28.92% 的Java用户
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 1;


        for (; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            nums[++i] = nums[j];
        }

        return i + 1;
    }

}
