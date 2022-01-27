package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:13
 * @Modified_By :
 */
public class O011 {
    public int minArray_violence(int[] numbers) {
        int n = numbers.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        return min;
    }

    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0;
        int righ = n - 1;
        int mid = -1;
        int min = Integer.MAX_VALUE;

        while (left <= righ) {
            mid = (left + righ) / 2;

            if (numbers[righ] < min) {
                min = numbers[righ];
            }

            if (numbers[mid] < numbers[righ]) {
                righ = mid;
            } else if (numbers[mid] > numbers[righ]) {
                left = mid + 1;
            } else {
                righ--;
            }
        }

        return min;
    }

    public static void main(String[] args) {
//        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
//        例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//
//        示例 1：
//        输入：[3,4,5,1,2]
//        输出：1
//
//        示例 2：
//        输入：[2,2,2,0,1]
//        输出：0
//
//        注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

//        int[] numbers = new int[]{3, 4, 5, 1, 2};
        int[] numbers = new int[]{1, 3, 5};
//        int[] numbers = new int[]{2, 2, 2, 0, 1};

        System.out.println(new O011().minArray(numbers));
        System.out.println(new O011().minArray_violence(numbers));
    }
}
