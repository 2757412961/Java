package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TO046 {
    Set<String> set = new HashSet<>();

    public int s2i(String str, int sta, int end) {
        if (str.charAt(sta) == '0' && end - sta > 1) {
            return -1;
        }

        if (end > str.length()) {
            return Integer.valueOf(str.substring(sta, str.length()));
        }

        return Integer.valueOf(str.substring(sta, end));
    }

    public void huishu(String str, int idx, String res) {
        if (idx >= str.length()) {
            set.add(res);
            return;
        }

        int val1 = s2i(str, idx, idx + 1);
        int val2 = s2i(str, idx, idx + 2);

        if (0 <= val1 && val1 <= 25) {
            huishu(str, idx + 1, res + (char) ('a' + val1));
        }
        if (0 <= val2 && val2 <= 25) {
            huishu(str, idx + 2, res + (char) ('a' + val2));
        }
    }

    public int translateNum_backtracking(int num) {
        String str = String.valueOf(num);

        huishu(str, 0, "");

        return set.size();
    }

    public int translateNum(int num) {
        int n = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        do {
            arr.add(num % 10);
            num /= 10;
            n++;
        } while (num > 0);

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 1; i < n; i++) {
            int las = arr.get(n - i);
            int now = arr.get(n - i - 1);
            dp[i + 1] += dp[i];
            if (las != 0 && las * 10 + now < 26) {
                dp[i + 1] += dp[i - 1];
            }
        }


        return dp[n];
    }

    public static void main(String[] args) {
//        int num = 12258;
//        int num = 1111;
        int num = 506;
//        0 ~ 25
//        12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

        System.out.println(new TO046().translateNum(num));
        System.out.println(new TO046().translateNum_backtracking(num));
    }
}
