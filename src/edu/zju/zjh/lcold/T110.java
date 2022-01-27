package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/17 上午 09:36
 * @Modified_By :
 */
public class T110 {
    boolean res = true;

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int righ = dfs(root.right);

        if (Math.abs(left - righ) > 1) res = false;

        return Math.max(left, righ) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return res;
    }

    public static void main(String[] args) {
        String inputs = "[3,9,20,null,null,15,7]";
//        String inputs = "[1,2,2,3,3,null,null,4,4]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T110().isBalanced(root));
    }
}
