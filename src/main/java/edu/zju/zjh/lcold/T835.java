package edu.zju.zjh.lcold;

public class T835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int res = 0;
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int con1 = 0, con2 = 0;

                for (int mi = 0; mi < m; mi++) {
                    for (int nj = 0; nj < n; nj++) {
                        if (mi + i < m && nj + j < n) {
                            if (A[mi + i][j + nj] == 1 && B[mi][nj] == 1) {
                                con1++;
                            }

                            if (B[mi + i][j + nj] == 1 && A[mi][nj] == 1) {
                                con2++;
                            }
                        }
                    }
                }

                res = Math.max(res, Math.max(con1, con2));
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] A = new int[][]{
//                {1, 1, 0},
//                {0, 1, 0},
//                {0, 1, 0}
//        };
//        int[][] B = new int[][]{
//                {0, 0, 0},
//                {0, 1, 1},
//                {0, 0, 1}
//        };
        int[][] A = new int[][]{
                {1, 0},
                {0, 0},
        };
        int[][] B = new int[][]{
                {0, 1},
                {1, 0}
        };

        System.out.println(new T835().largestOverlap(A, B));
    }
}
