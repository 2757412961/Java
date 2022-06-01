package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/1 9:21
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0400 {

    /**
     * 方法二：直接计算
     * 注意整形int会超出范围
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了30.10% 的Java用户
     */
    public int findNthDigit(int n) {
        long len = 1, base = 1;
        long count = n;

        // 减一
        count--;

        // 计算数字大小
        while (count > base * len * 9) {
            count -= base * len * 9;
            base *= 10;
            len++;
        }

        String str = String.valueOf(base + count / len);
        int idx = (int) (count % len);

        return str.charAt(idx) - '0';
    }

}
