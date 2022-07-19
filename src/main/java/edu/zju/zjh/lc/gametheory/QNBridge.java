package edu.zju.zjh.lc.gametheory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/7/19 8:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class QNBridge {

    /**
     * https://blog.csdn.net/qq_43203949/article/details/115444653
     * 过桥的两种方案
     * 方案一：最快的和最慢的过桥，回来最快的，然后最快的和次慢的过桥，回来最快的。（明显的贪心法，好处：回来得快。）
     * 方案二：最快的人和次快的先过桥，回来最快的，然后最慢的两个过桥，回来次快的。（好处：快的不会最慢的拖累）
     */
    /**
     * 动态规划法
     */
    private class S1 {

        public int nBridge(int n, int[] nums) {
            //先排序
            Arrays.sort(nums);
            int result = 0;
            int stay = n;
            //大于三人
            while (stay > 3) {
                //判断方案一快还是方案二，这里不等式化简了，自己写一下就知道了。
                if (nums[1] + nums[stay - 1] > 2 * nums[2]) {
                    // 第二种方案
                    result += 2 * nums[2] + nums[stay] + nums[1];
                } else {
                    // 第一种方案
                    result += 2 * nums[1] + nums[stay] + nums[stay - 1];
                }
                //过桥了两人
                stay -= 2;
            }

            if (stay == 3) {
                result += (nums[1] + nums[2] + nums[3]);
            } else {
                result += (nums[2]);
            }
            return result;
        }

    }

    /**
     * 贪心算法。感觉不行
     */
    private class S2 {

        public int nBridge(int n, int[] nums) {
            //先排序
            Arrays.sort(nums);
            int result = 0;
            int stay = n;
            //大于三人
            while (stay > 3) {
                //只使用方案二
                result += 2 * nums[1] + nums[stay] + nums[stay - 1];
                //过桥了两人
                stay -= 2;
            }

            if (stay == 3) {
                result += (nums[1] + nums[2] + nums[3]);
            } else {
                result += (nums[2]);
            }
            return result;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取人数
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        // 5
        // 1 3 6 8 12
        // sout 29
        System.out.println("最短时间： " + new QNBridge().new S1().nBridge(n, nums));
        System.out.println("最短时间： " + new QNBridge().new S2().nBridge(n, nums));
    }


}
