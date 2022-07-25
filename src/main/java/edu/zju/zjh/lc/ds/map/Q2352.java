package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/7/25 20:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q2352 {

    /**
     * 哈希表
     * 执行耗时:37 ms,击败了100.00% 的Java用户
     * 内存消耗:48.7 MB,击败了100.00% 的Java用户
     */
    private class S1 {

        public int equalPairs(int[][] grid) {
            int res = 0;
            int n = grid.length;
            Map<String, Integer> cnts = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(grid[i][j]).append(' ');
                }
                String key = sb.toString();
                cnts.put(key, cnts.getOrDefault(key, 0) + 1);
            }

            for (int j = 0; j < n; j++) {
                sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(grid[i][j]).append(' ');
                }
                String key = sb.toString();
                res += cnts.getOrDefault(key, 0);
            }

            return res;
        }

    }

}
