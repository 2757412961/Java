package main.java.edu.zju.zjh.lcold;

public class T968 {
    public int minCameraCover(TreeNode root) {
        int res = 0;




        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树，我们在树的节点上安装摄像头。
//        节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//        计算监控树的所有节点所需的最小摄像头数量。


        String inputs = "[0,0,null,0,0]";
//        String inputs = "[0,0,null,0,null,0,null,null,0]";
        TreeNode root = new CodeTree().deserialize(inputs);

        System.out.println(new T968().minCameraCover(root));
    }
}
