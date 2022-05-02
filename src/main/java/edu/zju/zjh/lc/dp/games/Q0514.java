package edu.zju.zjh.lc.dp.games;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/5/2 下午 04:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0514 {

    /**
     * Wrong way
     */
    /*
    public int findRotateSteps(String ring, String key) {
        int res = 0;
        int n = ring.length(), halfn = n / 2;
        int min[][] = new int[n][128];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < i + n; j++) {
                char c = ring.charAt(j % n);
                min[i][c] = j % n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j <= i + halfn; j++) {
                char c = ring.charAt(j % n);
                if (min[i][c] - i > j - i) min[i][c] = j % n;
            }
            for (int j = n + i; j >= n + i - halfn; j--) {
                char c = ring.charAt(j % n);
                if ((n + i - min[i][c]) % n > n + i - j) min[i][c] = j % n;
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < i + n; j++) {
//                char c = ring.charAt(j % n);
//                System.out.print(min[i][c] + " ");
//            }
//            System.out.println();
//        }

        int source = 0;
        for (int k = 0; k < key.length(); k++) {
            char tar = key.charAt(k);
            res += Math.min((n + min[source][tar] - source) % n, (n + source - min[source][tar]) % n);
            source = min[source][tar];
        }

        return res + key.length();
    }
     */

    private Map<Character, LinkedList<Integer>> mapToIndex = new HashMap<>();
    int[][] memo;

    public int dp(String ring, int i, String key, int j) {
        if (j == key.length()) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        char t = key.charAt(j);
        int res = Integer.MAX_VALUE;
        for (Integer k : mapToIndex.get(t)) {
            int diff = Math.abs(i - k);
            int dis = Math.min(diff, ring.length() - diff);
            int sub = dp(ring, k, key, j + 1);
            res = Math.min(res, dis + sub);
        }

        memo[i][j] = res;
        return res;
    }

    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            char ch = ring.charAt(i);
            if (!mapToIndex.containsKey(ch)) {
                mapToIndex.put(ch, new LinkedList<>());
            }
            mapToIndex.get(ch).add(i);
        }

        return dp(ring, 0, key, 0) + key.length();
    }

    public static void main(String[] args) {
        System.out.println(new Q0514().findRotateSteps("godding", "godding"));
        System.out.println(new Q0514().findRotateSteps("zvyii", "iivyz"));
        System.out.println(new Q0514().findRotateSteps("abcde", "ade"));
        System.out.println(new Q0514().findRotateSteps("pqwcx", "cpqwx"));
        System.out.println(new Q0514().findRotateSteps("godding", "gd"));
        System.out.println(new Q0514().findRotateSteps("godding", "godding"));
    }

}
