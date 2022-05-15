package edu.zju.zjh.topk.tengxun;

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

}
