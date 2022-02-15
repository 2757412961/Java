package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/7 下午 09:05
 * @Modified_By :
 */
public class T112 {
    Boolean res = false;
    int gsum;

    public void ishas(TreeNode root, int sum) {
        if (root == null) return;

        int newsum = sum + root.val;
        if (root.left == null && root.right == null && newsum == gsum) {
            res = true;
            return;
        }

        ishas(root.left, newsum);
        ishas(root.right, newsum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        gsum = sum;
        ishas(root, 0);

        return res;
    }

    public static void main(String[] args) {
        String inputs = "[5,4,8,11,null,13,4,7,2,null,null,null,1]"; // 48

        TreeNode root = new CodeTree().deserialize(inputs);
        int sum = 22;

        System.out.println(new T112().hasPathSum(root, sum));
    }
}
