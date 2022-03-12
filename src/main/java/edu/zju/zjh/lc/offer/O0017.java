package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 15:53
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0017 {

    /**
     * 实际上，本题的主要考点是大数越界情况下的打印。需要解决以下三个问题：
     * 1. 表示大数的变量类型：String
     * 2. 生成数字的字符串集：
     * 3. 递归生成全排列：
     * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     */
    public int[] printNumbers(int n) {
        int p = 1, len = (int) Math.pow(10, n);
        int[] nums = new int[len - 1];

        while (p < len) {
            nums[p - 1] = p;
            p++;
        }

        return nums;
    }

}
