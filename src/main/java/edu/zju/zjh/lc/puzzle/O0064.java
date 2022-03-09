package edu.zju.zjh.lc.puzzle;

/**
 * @author: zjh
 * @date : 2022/3/9 9:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0064 {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
