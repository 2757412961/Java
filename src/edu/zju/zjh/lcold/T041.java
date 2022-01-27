package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/27 下午 06:05
 * @Modified_By :
 */
public class T041 {
    public int firstMissingPositive(int[] nums) {
        int res = 1;
        int n = nums.length;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                map.put(nums[i], true);
            }
        }

        while (res > 0) {
            if (!map.containsKey(res)) {
                break;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
//        给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//        你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间

//        示例 1:
//        输入: [1,2,0]
//        输出: 3
//
//        示例 2://
//        输入: [3,4,-1,1]
//        输出: 2

//        示例 3://
//        输入: [7,8,9,11,12]
//        输出: 1

        int[] nums = new int[]{3, 4, -1, 1};

        System.out.println(new T041().firstMissingPositive(nums));
    }
}
