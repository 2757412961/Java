package edu.zju.zjh.lcold;

public class T035 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int i = 0;
        for (; i < n; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;

        System.out.println(new T035().searchInsert(nums, target));
    }
}
