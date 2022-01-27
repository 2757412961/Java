package edu.zju.zjh.lcold;

public class T837 {
    double res;
    int n, k, w;

    public void newRound(int num, double factor) {
        if (num >= k) {
            if (num <= n) {
                res += factor;
            }
        } else {
            for (int i = 1; i <= w; i++) {
                newRound(num + i, factor / w);
            }
        }
    }


    public double new21Game_violence(int N, int K, int W) {
        res = 0;
        n = N;
        k = K;
        w = W;

        newRound(0, 1.0);

        return res;
    }

    public double new21Game_old(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0;//用來計算 dp[K-1] 的變數
        for (int ix = K; ix < K + W; ix++) {// 先處理最後一輪的獲勝機率
            dp[ix] = ix <= N ? 1.0 : 0.0;// 小於等於N為1.0、大於N為0.0
            sum += dp[ix];// sum=dp[K]+dp[K+1]+...+dp[K+W-1]
        }
        //  推導 dp[K-1]
        if (K - 1 >= 0 && W > 0) dp[K - 1] = sum / W;
        for (int ix = K - 2; ix >= 0; ix--) {// 從 K-2 開始，由後向前推導出所有的值
            dp[ix] = dp[ix + 1] - (1.0 / W) * (dp[ix + 1 + W] - dp[ix + 1]);
        }
        return dp[0];
    }


    public double new21Game(int N, int K, int W) {
        int[] dp = new int[N + 1];
        dp[N] = 1;

        for (int i = N - 1; i >= 0; i++) {

        }

        return dp[0];
    }

    public static void main(String[] args) {
        int N = 21;
        int K = 17;
        int W = 10;

        System.out.println(new T837().new21Game(N, K, W));
        System.out.println(new T837().new21Game_old(N, K, W));
        System.out.println(new T837().new21Game_violence(N, K, W));
    }

}
