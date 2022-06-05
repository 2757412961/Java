package edu.zju.zjh.lc.design;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/5 14:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0297 {

    /**
     * 先序遍历
     * 执行耗时:8 ms,击败了85.07% 的Java用户
     * 内存消耗:43.3 MB,击败了54.33% 的Java用户
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        public static final String SPLIT = ",";
        public static final String NULL = "#";

        // Encodes a tree to a single string.
        private StringBuilder serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SPLIT);
                return sb;
            }

            sb.append(root.val).append(SPLIT);
            serialize(root.left, sb);
            serialize(root.right, sb);

            return sb;
        }

        public String serialize(TreeNode root) {
            return serialize(root, new StringBuilder()).toString();
        }

        // Decodes your encoded data to tree.
        private TreeNode deserialize(LinkedList<String> list) {
            String s = list.pollFirst();
            if (s.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(list);
            root.right = deserialize(list);

            return root;
        }

        public TreeNode deserialize(String data) {
            String[] datas = data.split(SPLIT);
            LinkedList<String> list = new LinkedList<>(Arrays.asList(datas));

            return deserialize(list);
        }
    }

}
