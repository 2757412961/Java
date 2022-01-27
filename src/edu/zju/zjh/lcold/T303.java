package edu.zju.zjh.lcold;

public class T303 {

    class NumArray {

        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * int param_1 = obj.sumRange(i,j);
         */

        private int[] nums = null;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int s = 0;
            for (int k = i; k <= j; k++) {
                s += nums[k];
            }
            return s;
        }
    }

    public static void main(String[] args) {

    }
}