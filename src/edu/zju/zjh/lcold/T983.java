package edu.zju.zjh.lcold;

public class T983 {
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int res = 0;
        int index = 0;
        int[] dp = new int[days[days.length - 1] + 1];

        for (int i = 1; i < dp.length && index < days.length; i++) {
            if (i != days[index]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = min(
                        dp[i - 1 < 0 ? 0 : i - 1] + costs[0],
                        dp[i - 7 < 0 ? 0 : i - 7] + costs[1],
                        dp[i - 30 < 0 ? 0 : i - 30] + costs[2]
                );
                index++;
            }
        }


        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = new int[]{2, 7, 15}; // 1, 7, 30

        System.out.println(new T983().mincostTickets(days, costs));
    }
}
