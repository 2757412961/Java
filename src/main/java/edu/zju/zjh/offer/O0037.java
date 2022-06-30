package edu.zju.zjh.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/4/10 下午 02:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0037 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *
     */
    private class S1 {

        public class Codec {

            public static final String NULL = "N";
            public static final String SPLIT_SEQ = " ";
            public static final String SPLIT_LINE = "#";

            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                if (root == null) return null;
                Queue<TreeNode> que = new LinkedList<>();
                StringBuilder sb = new StringBuilder();
                que.offer(root);

                while (!que.isEmpty()) {
                    int size = que.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = que.poll();
                        if (node == null) {
                            sb.append(NULL);
                        } else {
                            sb.append(node.val);
                            que.offer(node.left);
                            que.offer(node.right);
                        }
                        if (i != size - 1) sb.append(SPLIT_SEQ);
                    }
                    sb.append(SPLIT_LINE);
                }

                return sb.substring(0, sb.length() - 1).toString();
            }

            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                if (data == null) return null;
                String[] lines = data.split(SPLIT_LINE);
                TreeNode head = new TreeNode(Integer.parseInt(lines[0]));
                Queue<TreeNode> que = new LinkedList<>();
                que.offer(head);

                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    String[] nums = line.split(SPLIT_SEQ);
                    int size = que.size();
                    for (int j = 0; j < size; j++) {
                        TreeNode node = que.poll();
                        if (!nums[j * 2].equals(NULL)) {
                            TreeNode left = new TreeNode(Integer.parseInt(nums[j * 2]));
                            node.left = left;
                            que.offer(left);

                        }
                        if (!nums[j * 2 + 1].equals(NULL)) {
                            TreeNode right = new TreeNode(Integer.parseInt(nums[j * 2 + 1]));
                            node.right = right;
                            que.offer(right);
                        }
                    }
                }

                return head;
            }
        }

    }

    /**
     * 先序遍历
     * 执行耗时:8 ms,击败了85.07% 的Java用户
     * 内存消耗:43.3 MB,击败了54.33% 的Java用户
     */
    private class S2 {

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

}
