package edu.zju.zjh.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/7/5 15:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0118 {

    /**
     * 方法一：递推
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了49.23% 的Java用户
     */
    private class S1 {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>(numRows);

            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>(i + 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        List<Integer> last = res.get(i - 1);
                        list.add(last.get(j - 1) + last.get(j));
                    }
                }
                res.add(list);
            }

            return res;
        }

    }

}
