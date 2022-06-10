package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 03:09
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0053_I {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length, m = 0;
        int posl = 0, posr = 0;

        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m;
            } else if (nums[m] == target) {
                l = m + 1;
            }
        }
        posr = r;

        l = 0;
        r = nums.length;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m;
            } else if (nums[m] == target) {
                r = m ;
            }
        }
        posl = l;

        return posr - posl;
    }

}
