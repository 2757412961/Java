package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/14 下午 07:11
 * @Modified_By :
 */
public class T1300 {

//    给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近
//    target （最接近表示两者之差的绝对值最小）。
//    如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
//
//    示例 1：
//    输入：arr = [4,9,3], target = 10
//    输出：3
//    解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。

//    示例 2：
//    输入：arr = [2,3,5], target = 10
//    输出：5

//    示例 3：
//    输入：arr = [60864,25176,27249,21296,20204], target = 56803
//    输出：11361

//    提示：
//            1 <= arr.length <= 10^4
//            1 <= arr[i], target <= 10^5

    public int findBestValue_violence(int[] arr, int target) {
        int res = 0;
        int minabs = Integer.MAX_VALUE;
        int n = arr.length;
        int idx = 0;

        Arrays.sort(arr);

        int num = 0;
        int sum = 0;
        while (num <= arr[n - 1]) {
            while (idx < n && arr[idx] <= num) {
                sum += arr[idx];
                idx++;
            }

            int abs = Math.abs(sum + num * (n - idx) - target);
            if (abs < minabs) {
                res = num;
                minabs = abs;
            }

            num++;
        }

        return res;
    }

    public int getSum(int[] arr, int num) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                sum += arr[i];
            } else {
                sum += num;
            }
        }

        return sum;
    }


    public int findBestValue(int[] arr, int target) {
        int res = 0;
        int n = arr.length;
        int minabs = Integer.MAX_VALUE;
        int[] sums = new int[n];

        Arrays.sort(arr);

        int left = 0, righ = arr[n - 1], mid = -1, sum = -1;

        while (left <= righ) {
            mid = (left + righ) / 2;
            sum = getSum(arr, mid);

            if (target < sum) {
                righ = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }

        if (Math.abs(getSum(arr, res) - target) > Math.abs(getSum(arr, res + 1) - target)) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5};
        int target = 8;

        System.out.println(new T1300().findBestValue(arr, target));
        System.out.println(new T1300().findBestValue_violence(arr, target));
    }
}
