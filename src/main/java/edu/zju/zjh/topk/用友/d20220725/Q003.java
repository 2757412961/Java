package edu.zju.zjh.topk.用友.d20220725;

/**
 * @author: zjh
 * @date : 2022/7/25 下午 07:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q003 {

    public class Solution {

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param arr int整型一维数组
         * @param n   int整型
         * @return int整型
         */
        public int getMaxConsecutiveOnes(int[] arr, int n) {
            // write code here
            int res = 0;
            int i = 0, j = 0, cnt = 0;

            while (j < arr.length) {
                if (arr[j++] == 0) {
                    cnt++;
                }

                while (i < j && cnt > n) {
                    if (arr[i++] == 0) {
                        cnt--;
                    }
                }

                res = Math.max(res, j - i);
            }

            return res;
        }

    }

}
