package edu.zju.zjh.lcold;

public class T845 {
    public int longestMountain(int[] A) {
        int n = A.length;
        int maxH = 0;
        int i = 0, j;

        while (i < n - 1) {
            boolean incre = false;
            boolean decra = false;
            j = i;

            if (++j < n && A[j - 1] == A[j]){
                i++;
                continue;
            }
            j--;

            while (++j < n && A[j - 1] < A[j]) {
                incre = true;
            }
            j--;

            while (++j < n && A[j - 1] > A[j]) {
                decra = true;
            }
            j--;

            if (incre && decra) {
                maxH = Math.max(maxH, j - i + 1);
            }
            i = j;
        }

        return maxH;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,1,0,0,1,0};


        T845 t845 = new T845();
        System.out.print(t845.longestMountain(A));
    }
}
