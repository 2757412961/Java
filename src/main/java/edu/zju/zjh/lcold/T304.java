package edu.zju.zjh.lcold;

public class T304 {

    class NumMatrix {
        private int[][] matrix = null;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int s = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    s += matrix[i][j];
                }
            }
            return s;
        }
    }

    public static void main(String[] args) {

    }
}
