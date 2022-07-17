package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/17 21:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1491 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了20.60% 的Java用户
     */
    public double average(int[] salary) {
        int n = salary.length;
        int min = Integer.MAX_VALUE, max = -1;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }

        return (sum - min - max) / (n - 2);
    }

}
