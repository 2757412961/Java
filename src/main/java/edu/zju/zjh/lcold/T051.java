package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/3 上午 12:48
 * @Modified_By :
 */
public class T051 {
    List<List<String>> res = new ArrayList<>();

    public boolean isLegal(ArrayList<Integer[]> ans, int x, int y) {

        for (int i = 0; i < ans.size(); i++) {
            int bx = ans.get(i)[0];
            int by = ans.get(i)[1];

            if (x - bx == y - by || x + y == bx + by) return false;
        }

        return true;
    }

    public void huishu(boolean[] used, int pos, ArrayList<Integer[]> ans) {
        if (ans.size() == used.length) {
            ArrayList<String> board = new ArrayList<>();

            for (int i = 0; i < ans.size(); i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < ans.get(i)[1]; j++) {
                    sb.append('.');
                }

                sb.append('Q');

                for (int j = ans.get(i)[1] + 1; j < used.length; j++) {
                    sb.append('.');
                }

                board.add(sb.toString());
            }

            res.add(board);

            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                if (isLegal(ans, pos, i)) {
                    used[i] = true;
                    ans.add(new Integer[]{pos, i});
                    huishu(used, pos + 1, ans);
                    ans.remove(ans.size() - 1);
                    used[i] = false;
                }
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        boolean[] used = new boolean[n];

        huishu(used, 0, new ArrayList<>());

        return res;
    }

    public static void main(String[] args) {
//        n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//        上图为 8 皇后问题的一种解法。
//        给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//        每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 
//        示例：
//        输入：4
//        输出：[
//               [".Q..",  // 解法 1
//                "...Q",
//                "Q...",
//                "..Q."],
//
//               ["..Q.",  // 解法 2
//                "Q...",
//                "...Q",
//                ".Q.."]
//                ]
//        解释: 4 皇后问题存在两个不同的解法。

        int n = 4;

        List<List<String>> ans = new T051().solveNQueens(n);
        System.out.println("Finish!");
    }
}
