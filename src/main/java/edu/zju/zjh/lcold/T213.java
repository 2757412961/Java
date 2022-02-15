package edu.zju.zjh.lcold;

public class T213 {
    public int dg(int[] nums, int sta, int end) {
        int fro = 0;
        int lst = 0;
        int now = 0;

        for (int i = sta; i <= end; i++) {
            now = Math.max(lst, fro + nums[i]);
            fro = lst;
            lst = now;
        }

        return now;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return Math.max(dg(nums, 0, n - 2), dg(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new T213().rob(nums));

//        示例 1:
//
//        输入: [2,3,2]
//        输出: 3
//        解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//        示例 2:
//
//        输入: [1,2,3,1]
//        输出: 4
//        解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//             偷窃到的最高金额 = 1 + 3 = 4 。
    }
}
