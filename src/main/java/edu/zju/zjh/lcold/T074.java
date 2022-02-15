package edu.zju.zjh.lcold;

public class T074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<=0) return false;
        int i=0, j=matrix.length * matrix[0].length - 1, n = matrix[0].length;

        int index = -1, middle = 0;
        while(i <= j){
            index = (i+j)/2;
            middle = matrix[index/n][index%n];
            if(middle > target){
                j = index-1;
            } else if (middle < target){
                i = index+1;
            } else{
                return true;
            }
        }

        return false;
    }
}
