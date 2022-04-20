package edu.zju.zjh.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/4/20 下午 08:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * [1,1,2,0,0,4,5]
     * /1/2
     * [5,3,0]
     */
    public static TreeNode build(String str) {
        if (str.length() < 2) return null;
        char headc = str.charAt(1);
        if (headc < '1' || '9' < headc) return null;
        TreeNode head = new TreeNode(headc - '0');
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(head);

        int i = 1;
        while (i < str.length()) {
            TreeNode root = que.poll();

            i += 2;
            if (i < str.length()) {
                char chl = str.charAt(i);
                if (chl != '0') {
                    TreeNode left = new TreeNode(chl - '0');
                    root.left = left;
                    que.offer(left);
                }
            }
            i += 2;
            if (i < str.length()) {
                char chr = str.charAt(i);
                if (chr != '0') {
                    TreeNode right = new TreeNode(chr - '0');
                    root.right = right;
                    que.offer(right);
                }
            }
        }

        return head;
    }

    public static void print(TreeNode root) {
        if (root == null) System.out.println("[]");
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        builder.append('[');

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            builder.append(node.val).append(',');

            if (node.left != null) {
                que.offer(node.left);
            }
            if (node.right != null) {
                que.offer(node.right);
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fatherStr = sc.nextLine();
        String path = sc.nextLine();
        String childStr = sc.nextLine();

        TreeNode father = build(fatherStr);
        TreeNode child = build(childStr);

        TreeNode root = father;
        String[] paths = path.split("/");
        for (int i = 2; i < paths.length; i++) {
            int num = Integer.parseInt(paths[i]);
            if (root.left != null && root.left.val == num) {
                root = root.left;
            } else if (root.right != null && root.right.val == num) {
                root = root.right;
            }
        }

        root.val = child.val;
        root.left = child.left;
        root.right = child.right;

        print(father);
    }
}
