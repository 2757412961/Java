package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/21 下午 07:20
 * @Modified_By :
 */
public class T124 {
    int res = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int maxLeft = Math.max(dfs(root.left), 0);
        int maxRigh = Math.max(dfs(root.right), 0);
        int sum = maxLeft + maxRigh + root.val;

        if (sum > res) res = sum;

        return root.val + Math.max(maxLeft, maxRigh);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return res;
    }

    public static void main(String[] args) {
//        String inputs = "[-10,9,20,null,null,15,7]"; // 42
        String inputs = "[5,4,8,11,null,13,4,7,2,null,null,null,1]"; // 48
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        System.out.println(new T124().maxPathSum(root));
    }
}
