package edu.zju.zjh.lcold;

public class T617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode merge = new TreeNode(0);
        merge.val = t1.val + t2.val;
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);

        return merge;
    }

    public static void main(String[] args) {
//        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
//        那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

        String inputs1 = "[1,3,2,5]";
        TreeNode t1 = new CodeTree().deserialize(inputs1);
        String inputs2 = "[2,1,3,null,4,null,7]";
        TreeNode t2 = new CodeTree().deserialize(inputs2);

        new T617().mergeTrees(t1, t2).printTree();
    }
}
