package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/2 上午 10:21
 * @Modified_By :
 */
public class T718 {
    public int findLength_official(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public int findLength_violence(int[] A, int[] B) {
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int count = 0, x = i, y = j;
                while (x < A.length && y < B.length && A[x++] == B[y++]) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

    public int findLength(int[] A, int[] B) {
        int res = 0;

        for (int i = 0; i < B.length; i++) {
            int count = 0, x = 0, y = i;

            while (x < A.length && y < B.length) {
                if (A[x++] == B[y++]) {
                    count++;
                    res = Math.max(res, count);
                } else {
                    count = 0;
                }
            }
        }


        for (int i = 0; i < A.length; i++) {
            int count = 0, x = i, y = 0;

            while (x < A.length && y < B.length) {
                if (A[x++] == B[y++]) {
                    count++;
                    res = Math.max(res, count);
                } else {
                    count = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//        示例：
//        输入：
//        A: [1,2,3,2,1]
//        B: [3,2,1,4,7]
//        输出：3
//        解释：
//        长度最长的公共子数组是 [3, 2, 1]
//
//        提示：
//        1 <= len(A), len(B) <= 1000
//        0 <= A[i], B[i] < 100

        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};

        System.out.println(new T718().findLength(A, B));
        System.out.println(new T718().findLength_violence(A, B));
        System.out.println(new T718().findLength_official(A, B));
    }
}
