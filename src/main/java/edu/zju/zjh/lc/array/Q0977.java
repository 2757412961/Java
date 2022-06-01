package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/1 19:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0977 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:43.2 MB,击败了32.90% 的Java用户
     */
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, absl, absr, idx = nums.length - 1;
        int[] res = new int[nums.length];

        while (l <= r) {
            absl = Math.abs(nums[l]);
            absr = Math.abs(nums[r]);

            if (absl >= absr) {
                res[idx--] = absl * absl;
                l++;
            } else {
                res[idx--] = absr * absr;
                r--;
            }
        }

        return res;
    }

}
