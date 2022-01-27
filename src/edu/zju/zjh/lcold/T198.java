package edu.zju.zjh.lcold;

public class T198 {
    int res;
    int n;
    int[] mons;

    public void digui(int ind, int sum) {
        if (ind >= n) {
            res = Math.max(res, sum);
            return;
        }

        digui(ind + 1, sum);
        digui(ind + 2, sum + mons[ind]);
    }

    public int rob_violenece(int[] nums) {
        res = 0;
        n = nums.length;
        mons = nums;

        digui(0, 0);


        return res;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int fron = 0;
        int last = 0;
        int now = 0;

        if (n == 0) return 0;

        for (int i = 0; i < n; i++) {
            now = Math.max(last, fron + nums[i]);
            fron = last;
            last = now;
        }

        return now;
    }

//    输入: [1,2,3,1]
//    输出: 4
//    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//                 偷窃到的最高金额 = 1 + 3 = 4 。
//
//    输入: [2,7,9,3,1]
//    输出: 12
//    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//                 偷窃到的最高金额 = 2 + 9 + 1 = 12 。

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};

        System.out.println(new T198().rob(nums));
        System.out.println(new T198().rob_violenece(nums));
    }
}
