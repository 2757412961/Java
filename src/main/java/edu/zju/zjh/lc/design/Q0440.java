package edu.zju.zjh.lc.design;

/**
 * @author: zjh
 * @date : 2022/6/5 15:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0440 {

    /**
     * 參考力扣官方答案
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了32.04% 的Java用户
     */
    /**
     * 以数字 i 开头的所有数字串 按字典序一定 排在以数字 i+1 开头的所有数字串的前面。
     * 对每个数字 i，唯一能做的就是确定以数字 i 开头的字符串的个数。
     * 但是有一个限制是，以 i 开头的数字不能超过最大数字 nn。
     */
    public int getCount(int x, int n) {
        int steps = 0;
        long cur = x, next = x + 1;

        //当前的前缀当然不能大于上界
        for (; cur <= n; cur *= 10, next *= 10) {
            //说明区间没有超过最大数字n
            steps += (int) (Math.min(next, n + 1) - cur);
        }

        return steps;
    }

    public int findKthNumber(int n, int k) {
        int num = 0;

        k--;
        for (int x = 1; x <= n; ) {
            if (k == 0) return x;
            int count = getCount(x, n);
            if (count > k) {
                // 说明以数字i开头的数字串太多了，并且第k个数字一定是以数字i开头。
                // 此时数字i更新为10*i，缩小搜索范围。
                // 位置k向前移动一位，因为新数字i字典序向后移动一位了。
                k -= 1;
                x *= 10;
            } else if (count <= k) {
                //第k个数不在当前前缀下
                k -= count;
                x++;
            }
        }

        return -1;
    }

}
