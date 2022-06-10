package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 10:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0056_II {

    public int singleNumber(int[] nums) {
        int res = 0;
        int[] counts = new int[32];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = 0; j < counts.length; j++) {
                counts[j] += n & 1;
                n >>>= 1;
            }
        }

        for (int i = counts.length - 1; i >= 0; i--) {
            res = (res << 1) | counts[i] % 3;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O0056_II().singleNumber(new int[]{3, 4, 3, 3}));
    }

}
