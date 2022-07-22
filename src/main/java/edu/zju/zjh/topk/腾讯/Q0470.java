package edu.zju.zjh.topk.腾讯;

import java.util.Random;

/**
 * @author: zjh
 * @date : 2022/5/15 19:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0470 {

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    public int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public int rand10() {
        int a = -1, b = -1;
        while ((a = rand7()) > 6) ;
        while ((b = rand7()) > 5) ;

        return a % 2 == 0 ? b : b + 5;
    }

    private class S2 {

        /**
         * 执行耗时:6 ms,击败了44.93% 的Java用户
         * 内存消耗:46.6 MB,击败了96.60% 的Java用户
         */
        public int rand10() {
            int a, b;

            while ((a = rand7()) > 6) ;
            while ((b = rand7()) > 5) ;

            return (a % 2) * 5 + b;
        }

    }

}
