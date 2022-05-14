package edu.zju.zjh.topk.huawei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/5/14 19:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0554 {

    public int leastBricks(List<List<Integer>> wall) {
        int res = 0;
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> line = wall.get(i);
            int sum = 0;
            int len = line.size();
            for (int j = 0; j < len - 1; j++) {
                sum += line.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            res = Math.max(res, item.getValue());
        }

        return n - res;
    }
}
