package main.java.edu.zju.zjh.lcold;

public class T1026 {
    private int max_ = -1;

    public void dfsMM(TreeNode root, int maxVal, int minVal) {
        if (root == null) return;

        maxVal = Math.max(maxVal, root.val);
        minVal = Math.min(minVal, root.val);
        max_ = Math.max(max_, maxVal - minVal);

        dfsMM(root.left, maxVal, minVal);
        dfsMM(root.right, maxVal, minVal);
    }


    public int maxAncestorDiff(TreeNode root) {
        dfsMM(root, -1, 100001);
        return max_;
    }

    public static void main(String[] args) {
        String inputs = "[8,3,10,1,6,null,14,null,null,4,7,13]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        T1026 t1026 = new T1026();
        System.out.println(t1026.maxAncestorDiff(root));
    }
}
