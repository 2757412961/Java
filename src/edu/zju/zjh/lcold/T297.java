package edu.zju.zjh.lcold; /**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/16 上午 10:12
 * @Modified_By :
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class T297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node != null) {
                que.add(node.left);
                que.add(node.right);
                sb.append(node.val);
                sb.append(',');
            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        String[] filter = sb.toString().split(",");
        int idx = filter.length - 1;
        for (; idx >= 0; idx--) {
            if (filter[idx].equals("null")) {
                filter[idx] = null;
            } else {
                break;
            }
        }

        sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < filter.length; i++) {
            if (filter[i] != null) {
                sb.append(filter[i]);
                sb.append(',');
            }
        }
        if (sb.lastIndexOf(",") > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] datas = data.substring(1, data.length() - 1).split(",");
        int n = datas.length;

        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (datas[i].equals("null")) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.valueOf(datas[i]));
            }
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(nodes[0]);
        int idx = 1;

        while (!que.isEmpty()) {
            TreeNode root = que.poll();

            if (idx < n) {
                TreeNode left = nodes[idx++];
                if (left != null) {
                    root.left = left;
                    que.add(left);
                }
            }
            if (idx < n) {
                TreeNode righ = nodes[idx++];
                if (righ != null) {
                    root.right = righ;
                    que.add(righ);
                }
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
//        String data = "[1,2,3,null,null,4,5]";
        String data = "[]";


        TreeNode root = new T297().deserialize(data);
        System.out.println(new T297().serialize(root));
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));