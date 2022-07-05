package edu.zju.zjh.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/7/5 15:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0119 {

    /**
     * 方法一：递推
     * 执行耗时:1 ms,击败了77.02% 的Java用户
     * 内存消耗:39.5 MB,击败了5.14% 的Java用户
     */
    private class S1 {

        public List<Integer> getRow(int rowIndex) {
            int numRows = rowIndex + 1;
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

            return res.get(rowIndex);
        }

    }

    /**
     * 方法二：线性递推
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class S2 {

        class Solution {
            public List<Integer> getRow(int rowIndex) {
                List<Integer> row = new ArrayList<Integer>();
                row.add(1);
                for (int i = 1; i <= rowIndex; ++i) {
                    row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
                }
                return row;
            }
        }

    }

}
