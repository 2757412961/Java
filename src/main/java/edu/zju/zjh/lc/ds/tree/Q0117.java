package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/18 17:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0117 {

    public class Node {
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
     * 递归法平凡版
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了11.91% 的Java用户
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Node node = null, next = root.next;

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            node = root.right;
        } else if (root.left != null && root.right == null) {
            node = root.left;
        } else if (root.left == null && root.right != null) {
            node = root.right;
        }

        while (node != null && next != null) {
            if (next.left != null) {
                node.next = next.left;
                break;
            }
            if (next.right != null) {
                node.next = next.right;
                break;
            }
            next = next.next;
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        connect(root.right);
        connect(root.left);

        return root;
    }

}
