package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:11
 * @Modified_By :
 */
public class T114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode righ = root.right;

        if (left == null && righ == null) {
            flatten(null);
        } else if (left == null && righ != null) {
            flatten(root.right);
        } else if (left != null && righ == null) {
            flatten(root.left);
            root.right = left;
            root.left = null;
        } else {
            flatten(root.left);
            root.right = left;
            root.left = null;
            while (left.right != null) {
                left = left.right;
            }
            left.right = righ;
            flatten(righ);
        }
    }

    public static void main(String[] args) {
        String inputs = "[1,2,5,3,4,null,6]"; // 48

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        new T114().flatten(root);
        System.out.println(new CodeTree().serialize(root));
    }
}
