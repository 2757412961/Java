package edu.zju.zjh.lc.ds.tree;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/8 15:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 执行耗时:2 ms,击败了70.10% 的Java用户
     * 内存消耗:41.6 MB,击败了39.90% 的Java用户
     */
    public Node connect(Node root) {
        LinkedList<Node> q = new LinkedList<>();
        if (root != null) q.offerLast(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.pollFirst();
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
                if (i != size - 1) {
                    node.next = q.peekFirst();
                }
            }
        }

        return root;
    }

}
