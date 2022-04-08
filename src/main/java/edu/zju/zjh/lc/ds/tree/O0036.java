package edu.zju.zjh.lc.ds.tree;

public class O0036 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node first, last;

    public void build(Node root) {
        if (root == null) return;

        build(root.left);
        if (first == null) {
            first = root;
            last = root;
        } else {
            last.right = root;
            root.left = last;
            last = root;
        }
        build(root.right);
    }

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        build(root);
        first.left = last;
        last.right = first;

        return first;
    }

}
