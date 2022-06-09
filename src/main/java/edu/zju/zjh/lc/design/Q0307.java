package edu.zju.zjh.lc.design;

/**
 * @author: zjh
 * @date : 2022/6/9 14:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0307 {

    /**
     * 线段树详解「汇总级别整理 🔥🔥🔥」
     * https://leetcode.cn/problems/range-sum-query-mutable/solution/by-lfool-v3x9/
     * <p>
     * 执行耗时:83 ms,击败了50.95% 的Java用户
     * 内存消耗:73.8 MB,击败了5.03% 的Java用户
     */
    class NumArray {

        private final int n;
        private final int[] arr;
        private final int[] tree;
        private final int[] add;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.arr = nums;
            // 必须开 4 倍长度的数组
            this.tree = new int[n << 2];
            this.add = new int[n << 2];
            buildTree(0, n - 1, 1);
        }

        public void update(int index, int val) {
            update(0, n - 1, 1, index, val);
        }

        public int sumRange(int left, int right) {
            return query(0, n - 1, left, right, 1);
        }

        public void updateRange(int l, int r, int val) {
            update(0, n - 1, 1, l, r, val);
        }

        private void buildTree(int start, int end, int rootId) {
            if (start == end) {
                tree[rootId] = arr[start];
                return;
            }
            int mid = (start + end) >> 1;
            buildTree(start, mid, rootId << 1);
            buildTree(mid + 1, end, rootId << 1 | 1);
            pushUp(rootId);
        }

        private void update(int start, int end, int rootId, int updateIndex, int val) {
            if (start == end) {
                arr[start] = tree[rootId] = val;
                return;
            }
            int mid = (start + end) >> 1;
            if (updateIndex > mid) {
                update(mid + 1, end, rootId << 1 | 1, updateIndex, val);
            } else {
                update(start, mid, rootId << 1, updateIndex, val);
            }
            pushUp(rootId);
        }

        private void update(int start, int end, int rootId, int l, int r, int val) {
            // 无交集
            if (r < start || l > end) return;
                // 如果本区间完全在操作区间 [l, r] 以内
            else if (l <= start && end <= r) {
                // 更新数字和，向上保持正确
                tree[rootId] += val * (end - start + 1);
                // 增加 add 标记，表示本区间的 Sum 正确，子区间的 Sum 仍需要根据 add 的值来调整
                add[rootId] += val;
                return;
            }
            int mid = (start + end) >> 1;
            // 下推标记
            pushDown(rootId, mid - start + 1, end - mid);
            update(start, mid, rootId << 1, l, r, val);
            update(mid + 1, end, rootId << 1 | 1, l, r, val);
            pushUp(rootId);
        }

        private int query(int start, int end, int l, int r, int rootId) {
            if (r < start || l > end) return 0;
            else if (l <= start && end <= r) return tree[rootId];
            int mid = (start + end) >> 1;
            // 下推标记
            pushDown(rootId, mid - start + 1, end - mid);
            int lSum = query(start, mid, l, r, rootId << 1);
            int rSum = query(mid + 1, end, l, r, rootId << 1 | 1);
            return lSum + rSum;
        }

        private void pushUp(int rootId) {
            tree[rootId] = tree[rootId << 1] + tree[rootId << 1 | 1];
        }

        private void pushDown(int rootId, int leftNum, int rightNum) {
            if (add[rootId] == 0) return;
            // 下推标记
            add[rootId << 1] += add[rootId];
            add[rootId << 1 | 1] += add[rootId];
            // 修改子节点的 Sum 使之与对应的 add 相对应
            tree[rootId << 1] += leftNum * add[rootId];
            tree[rootId << 1 | 1] += rightNum * add[rootId];
            add[rootId] = 0;
        }

    }


}
