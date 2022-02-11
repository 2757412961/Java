package main.java.edu.zju.zjh.lcold;

public class T704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;

        while (left < right) {
            middle = (left + right) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                return middle;
            }
        }

        middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new T704().search(nums, 9));
    }
}
