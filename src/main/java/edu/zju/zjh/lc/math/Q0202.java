package edu.zju.zjh.lc.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/7/10 17:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0202 {

    /**
     * 方法一：用哈希集合检测循环
     * 对于 3 位数的数字，它不可能大于 243。这意味着它要么被困在 243 以下的循环内，要么跌到 1。
     * 4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止。所以我们知道，最坏的情况下，
     * 算法可能会在 243 以下的所有数字上循环，然后回到它已经到过的一个循环或者回到 1。
     * <p>
     * 执行耗时:2 ms,击败了8.41% 的Java用户
     * 内存消耗:38.8 MB,击败了32.96% 的Java用户
     */
    private class S1 {

        private Map<Integer, Integer> square = new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 1);
            put(2, 4);
            put(3, 9);
            put(4, 16);
            put(5, 25);
            put(6, 36);
            put(7, 49);
            put(8, 64);
            put(9, 81);
        }};

        private int cal(int num) {
            int res = 0;

            while (num != 0) {
                res += square.get(num % 10);
                num /= 10;
            }

            return res;
        }

        public boolean isHappy(int n) {
            Set<Integer> unique = new HashSet<>();

            while (n != 1) {
                if (unique.contains(n)) return false;
                unique.add(n);
                n = cal(n);
            }

            return true;
        }

    }

    /**
     * 方法二：快慢指针法
     * 弗洛伊德循环查找算法
     */

}
