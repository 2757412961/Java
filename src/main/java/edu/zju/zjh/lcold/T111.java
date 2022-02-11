package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/21 上午 12:26
 * @Modified_By :
 */
public class T111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            int left = minDepth(root.left);
            int righ = minDepth(root.right);

            return Math.min(left, righ) + 1;
        }
    }

    public static void main(String[] args) {
//        String inputs = "[3,9,20,null,null,15,7]";
        String inputs = "[1,2]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));


        System.out.println(new T111().minDepth(root));
    }
}
