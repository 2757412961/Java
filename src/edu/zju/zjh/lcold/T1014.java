package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/17 下午 01:09
 * @Modified_By :
 */
public class T1014 {
    public int maxScoreSightseeingPair_violence(int[] A) {
        int res = 0;
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int now = A[i] + A[j] + i - j;
                if (now > res) {
                    res = now;
                }
            }
        }

        return res;
    }

    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE;
        int n = A.length;
        int maxAi = Integer.MIN_VALUE, maxAj = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            maxAi = Math.max(maxAi, A[i - 1] + i - 1);
            res = Math.max(res, maxAi + A[i] - i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{8, 1, 5, 2, 6};


        System.out.println(new T1014().maxScoreSightseeingPair(A));
        System.out.println(new T1014().maxScoreSightseeingPair_violence(A));
    }
}
