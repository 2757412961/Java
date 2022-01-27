package edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/20 下午 11:44
 * @Modified_By :
 */
public class T167 {
    public int[] twoSum_violence(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{0, 0};
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, righ = n - 1;

        while (left < righ) {
            if (numbers[left] + numbers[righ] < target) {
                left++;
            } else if (numbers[left] + numbers[righ] > target) {
                righ--;
            } else {
                return new int[]{left + 1, righ + 1};
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(new T167().twoSum(numbers, target)));
        System.out.println(Arrays.toString(new T167().twoSum_violence(numbers, target)));
    }
}
