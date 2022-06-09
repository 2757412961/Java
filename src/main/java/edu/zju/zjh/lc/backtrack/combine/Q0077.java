package edu.zju.zjh.lc.backtrack.combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 13:53
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0077 {

    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    private void backTrack(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
//        if (path.size() > k) return;
//        if (start == n + 1) return;
//
//        path.addLast(start);
//        backTrack(n, k, start + 1);
//        path.removeLast();
//        backTrack(n, k, start + 1);
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backTrack(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTrack(n, k, 1);

        return res;
    }

    private class S2 {

        public List<List<Integer>> combine(int n, int k, int start, List<List<Integer>> res, LinkedList<Integer> path) {
            if (k == path.size()) {
                res.add(new LinkedList<>(path));
                return res;
            }

            for (int i = start; i <= n; i++) {
                path.offerLast(i);
                combine(n, k, i + 1, res, path);
                path.removeLast();
            }

            return res;
        }

        public List<List<Integer>> combine(int n, int k) {
            return combine(n, k, 1, new ArrayList<>(100), new LinkedList<>());
        }

    }

}
