package edu.zju.zjh.lc.ds.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zjh
 * @date : 2022/5/19 15:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0652 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<String, TreeNode> map = new HashMap<>();
    public Set<TreeNode> set = new HashSet<>();

    public String dfs(TreeNode root) {
        if (root == null) return "#";

        String left = dfs(root.left);
        String right = dfs(root.right);
        String tree = '(' + left + root.val + right + ')';

        if (!map.containsKey(tree)) {
            map.put(tree, root);
        } else {
            set.add(map.get(tree));
        }

        return tree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return set.stream().collect(Collectors.toList());
    }

}
