package edu.zju.zjh.lcold;

import java.util.Scanner;

public class TreeInput {
    public static String[] Inputs(){
        Scanner scanner = new Scanner(System.in);

        String inputs = scanner.next();
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        return stringNodes;
    }

    public static void main(String[] args) {
        String inputs = "[8,3,10,1,6,null,14,null,null,4,7,13]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");
//        String[] stringNodes = TreeInput.Inputs();

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();


    }
}
