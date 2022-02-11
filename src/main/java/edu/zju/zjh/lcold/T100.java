package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/7 上午 10:11
 * @Modified_By :
 */
public class T100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }


    public static void main(String[] args) {
        String inputsp = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode p = new CodeTree().deserialize(inputsp);

        String inputsq = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode q = new CodeTree().deserialize(inputsq);


        System.out.println(new T100().isSameTree(p, q));
    }
}
