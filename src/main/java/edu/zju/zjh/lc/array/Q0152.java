package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/5 13:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0152 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了46.98% 的Java用户
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, prod = 1;

        for (int i = 0; i < nums.length; i++) {
            if (prod == 0) {
                prod = 1;
            }
            prod *= nums[i];
            res = Math.max(res, prod);
        }
        prod = 1;
        for (int i = nums.length; i >= 0; i--) {
            if (prod == 0) {
                prod = 1;
            }
            prod *= nums[i];
            res = Math.max(res, prod);
        }

        return res;
    }

}
