package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T974 {


    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int sum = 0;
        int n = A.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += A[i];

            int key = (sum % K + K) % K;
            int val;
            if (map.containsKey(key)) {
                val = map.get(key);
            } else {
                val = 0;
            }
            res += val;
            map.put(key, val + 1);
        }

        return res;
    }


    public int subarraysDivByK_violence(int[] A, int K) {
        int res = 0;
        int n = A.length;
        int[] sums = new int[n + 1];

        sums[0] = 0;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((sums[j] - sums[i]) % K == 0) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int K = 5;

        System.out.println(new T974().subarraysDivByK(A, K));
        System.out.println(new T974().subarraysDivByK_violence(A, K));
    }

}
