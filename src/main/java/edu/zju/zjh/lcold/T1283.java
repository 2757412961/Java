package main.java.edu.zju.zjh.lcold;

public class T1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        double res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int left = 1, righ = 1, mid = 1;

        int maxSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        left = Math.max(1, maxSum / threshold);
        righ = max;


        while (left <= righ) {
            sum = 0;
            mid = (left + righ) / 2;

            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) nums[i] / mid);
            }

            if (sum <= threshold) {
                res = Math.min(res, mid);
                righ = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 9};
        int threshold = 6;

        System.out.println(new T1283().smallestDivisor(nums, threshold));
    }
}
