package main.java.edu.zju.zjh.lcold;

public class T1004 {
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0, righ = 0;

        while (righ < A.length) {
            if (A[righ] == 1) {
                res = Math.max(res, righ - left + 1);
            } else {
                if (K > 0) {
                    K--;
                    res = Math.max(res, righ - left + 1);
                } else {
                    if (A[left] == 0) {
                        K++;
                    }
                    left++;
                    continue;
                }
            }

            righ++;
        }

        return res;
    }

    public static void main(String[] args) {
//        示例 1：
//        输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        输出：6
//        解释：
//        [1,1,1,0,0,1,1,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 6。

//        示例 2：
//        输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        输出：10
//        解释：
//        [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 10。

//        输入：
//        [1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1]
//        9
//        预期结果：
//        32

//        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        int K = 2;

//        int[] A = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int K = 3;

        int[] A = new int[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1};
        int K = 9;

        System.out.println(new T1004().longestOnes(A, K));
    }
}
