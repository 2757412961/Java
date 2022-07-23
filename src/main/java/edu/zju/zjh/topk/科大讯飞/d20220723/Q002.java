package edu.zju.zjh.topk.科大讯飞.d20220723;

import java.util.Scanner;

public class Q002 {

    // 本题为考试多行输入输出规范示例，无需提交，不计分。

    //20
    //0 0 0 3 1 2 3 4 5 6 7 8 1 4 2 4 3 5 5 0 5 5 2 0 2 2 3 0 3 3 4 5 6 1 3 7 4 0 5 2

    //165
    public static class Main {
        public static boolean helper(int x1, int y1, int x2, int y2) {
            return x1 * x2 + y1 * y2 == 0;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int ans = 0;
            int n = sc.nextInt();
            int[][] points = new int[n][2];
            // x = points[2][0]
            // y = points[2][1]
            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int x1 = points[i][0] - points[j][0];
                    int y1 = points[i][1] - points[j][1];
                    for (int k = j + 1; k < n; k++) {
                        int x2 = points[i][0] - points[k][0];
                        int y2 = points[i][1] - points[k][1];
                        int x3 = points[j][0] - points[k][0];
                        int y3 = points[j][1] - points[k][1];
                        if (helper(x1, y1, x2, y2) || helper(x1, y1, x3, y3) || helper(x2, y2, x3, y3)) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
