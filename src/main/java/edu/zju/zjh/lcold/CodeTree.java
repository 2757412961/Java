package main.java.edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/21 下午 08:35
 * @Modified_By :
 */
public class CodeTree {

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
        if (sb.lastIndexOf(",") > 0) {
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
        String inputs = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = new CodeTree().deserialize(inputs);

        System.out.println(new CodeTree().serialize(root));
        System.out.println(inputs);
    }
}
