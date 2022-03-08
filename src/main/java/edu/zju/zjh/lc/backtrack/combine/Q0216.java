package edu.zju.zjh.lc.backtrack.combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 16:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0216 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    private void backTrack(int k, int n, int start) {
        if (n < 0 || k < path.size()) return;
        if (n == 0 && k == path.size()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break;
            path.addLast(i);
            backTrack(k, n - i, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 50) return res;
        backTrack(k, n, 1);

        return res;
    }

}
