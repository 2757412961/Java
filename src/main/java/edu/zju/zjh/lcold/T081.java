package edu.zju.zjh.lcold;

public class T081 {
    public boolean search(int[] nums, int target) {
        int sta = 0;
        int end = nums.length - 1;
        int mid;

        while (sta <= end) {
            mid = (sta + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[sta] < nums[mid]) {
                if (nums[sta] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    sta = mid + 1;
                }
            } else if (nums[sta] > nums[mid]) {
                if (nums[mid] < target && target <= nums[end]) {
                    sta = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[sta] == nums[mid]) {
                sta++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 1};

        T081 t081 = new T081();
        System.out.println(t081.search(nums, 0));
    }
}
