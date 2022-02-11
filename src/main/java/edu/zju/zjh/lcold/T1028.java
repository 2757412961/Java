package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/18 下午 03:17
 * @Modified_By :
 */
public class T1028 {
    public TreeNode recoverFromPreorder(String S) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<Integer> depths = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        while (idx < S.length()) {
            int depth = 0;
            String num = "";

            while (idx < S.length() && S.charAt(idx) == '-') {
                depth++;
                idx++;
            }

            while (idx < S.length() && '0' <= S.charAt(idx) && S.charAt(idx) <= '9') {
                num += S.charAt(idx);
                idx++;
            }

            nodes.add(new TreeNode(Integer.valueOf(num)));
            depths.add(depth);
        }

        idx = 0;
        while (idx < nodes.size()) {
            TreeNode node = nodes.get(idx);
            int depth = depths.get(idx);

            if (!stack.isEmpty()) {
                int parent = stack.peek();

                if (depth > depths.get(parent)) {
                    nodes.get(parent).left = node;
                } else {
                    while (!stack.isEmpty()) {
                        int top = stack.pop();
                        if (depths.get(top) < depth) {
                            nodes.get(top).right = node;
                            break;
                        }
                    }
                }
            }

            stack.push(idx);
            idx++;
        }

        return nodes.get(0);
    }


    public static void main(String[] args) {
//        String S = "1-2--3--4-5--6--7";
//        String S = "1-2--3---4-5--6---7";
        String S = "1-401--349---90--88";


        new T1028().recoverFromPreorder(S);
    }
}
