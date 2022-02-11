package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/4 下午 03:25
 * @Modified_By :
 */
public class T257 {
    List<String> res = new ArrayList<>();

    public void dfs(TreeNode root, ArrayList<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(root.val);

            res.add(sb.toString());
            return;
        }

        path.add(root.val);
        dfs(root.left, path);
        path.remove(path.size() - 1);

        path.add(root.val);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());

        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//        输入:
//
//                  1
//                /   \
//               2     3
//                \
//                 5
//
//        输出: ["1->2->5", "1->3"]
//        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3


        String inputs = "[1,2,3,null,5]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        List<String> r = new T257().binaryTreePaths(root);
        System.out.println("Finish!");
    }
}
