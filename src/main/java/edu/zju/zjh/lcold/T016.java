package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/25 下午 08:05
 * @Modified_By :
 */
public class T016 {

    public int threeSumClosest_violence(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(sum + nums[k] - target) < Math.abs(target - res)) {
                        res = sum + nums[k];
                    }
                }
                sum -= nums[j];
            }
        }


        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        Arrays.sort(nums);

        int i = 0, s = 1, e = n - 1;
        while (s < e) {
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    s++;
                } else if (sum > target) {
                    e--;
                } else {
                    break;
                }
            }

            if (nums[i] + nums[s] + nums[e] == target && s != e) {
                break;
            }

            i++;
            s = i + 1;
            e = n - 1;
        }


        return res;
    }

    public static void main(String[] args) {

//        给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
//        返回这三个数的和。假定每组输入只存在唯一答案。
//
//        示例：
//        输入：nums = [-1,2,1,-4], target = 1
//        输出：2
//        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;
//        int[] nums = new int[]{1, 1, 1, 0};
//        int target = -100;
        int[] nums = new int[]{-3, -2, -5, 3, -4};
        int target = -1;

        System.out.println(new T016().threeSumClosest(nums, target));
        System.out.println(new T016().threeSumClosest_violence(nums, target));
    }
}
