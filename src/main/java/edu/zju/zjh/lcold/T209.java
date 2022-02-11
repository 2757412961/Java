package main.java.edu.zju.zjh.lcold;

public class T209 {
    public int minSubArrayLen_violence(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0, count = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                count++;
                if (sum >= s) {
                    break;
                }
            }

            if (sum >= s) {
                res = Math.min(res, count);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0, count = 0, i = 0, j = 0;

        while (i < n) {
            while (j < n && sum < s) {
                sum += nums[j++];
                count++;
            }

            if (sum >= s) {
                res = Math.min(res, count);
            }
            sum -= nums[i];
            count--;
            i++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
//        int s = 7;
//        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int s = 11;
        int[] nums = new int[]{1, 2, 3, 4, 5};

        System.out.println(new T209().minSubArrayLen(s, nums));
        System.out.println(new T209().minSubArrayLen_violence(s, nums));
    }
}
