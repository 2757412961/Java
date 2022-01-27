package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/21 下午 04:19
 * @Modified_By :
 */
public class T095 {
    public List<TreeNode> digui(int sta, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (sta > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = sta; i <= end; i++) {
            List<TreeNode> left = digui(sta, i - 1);
            List<TreeNode> righ = digui(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : righ) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;

                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }

        return digui(1, n);
    }

    public static void main(String[] args) {
//        输入：3
//        输出：
//        [
//          [1,null,3,2],
//          [3,2,null,1],
//          [3,1,null,null,2],
//          [2,1,3],
//          [1,null,2,null,3]
//        ]
//        解释：
//        以上的输出对应以下 5 种不同结构的二叉搜索树：


        int n = 3;

        List<TreeNode> trees = new T095().generateTrees(n);
        System.out.println();
    }
}
