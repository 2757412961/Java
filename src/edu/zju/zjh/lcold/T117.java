package edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

public class T117 {
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

    ;

    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        if (root != null) que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node node = que.poll();
                if (last != null) {
                    last.next = node;
                }
                last = node;

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }

        return root;
    }
}
