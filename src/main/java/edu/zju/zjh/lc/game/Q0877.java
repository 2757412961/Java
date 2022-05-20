package edu.zju.zjh.lc.game;

/**
 * @author: zjh
 * @date : 2022/5/20 14:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0877 {

    private int[][] memo;

    public int minmax(int[] piles, int l, int r, boolean isA) {
        if (memo[l][r] != 0) return memo[l][r];
        if (isA) {
            if (l == r) return piles[l];
            int res = Math.max(
                    minmax(piles, l + 1, r, false) + piles[l],
                    minmax(piles, l, r - 1, false) + piles[r]
            );
            memo[l][r] = res;
        } else {
            if (l == r) return -piles[l];
            int res = Math.min(
                    minmax(piles, l + 1, r, true) - piles[l],
                    minmax(piles, l, r - 1, true) - piles[r]
            );
            memo[l][r] = res;
        }

        return memo[l][r];
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];

        return minmax(piles, 0, n - 1, true) > 0;
    }

    /**
     * 我们只要对规则深入思考，就会大惊失色：只要你足够聪明，你是必胜无疑的，因为你是先手。
     * 因为题目有两个条件很重要：一是石头总共有偶数堆，石头的总数是奇数。这两个看似增加游戏公平性的条件，反而使该游戏成为了一个割韭菜游戏。
     *
     * 我们以 piles=[2, 1, 9, 5] 讲解，假设这四堆石头从左到右的索引分别是 1，2，3，4。
     *  你最开始可以选择第 1 堆或第 4 堆。
     *  如果你想要偶数堆，你就拿第 4 堆，这样留给对手的选择只有第 1、3 堆，他不管怎么拿，第 2 堆又会暴露出来，你就可以拿。
     *  同理，如果你想拿奇数堆，你就拿第 1 堆，留给对手的只有第 2、4 堆，他不管怎么拿，第 3 堆又给你暴露出来了。
     */
    public boolean stoneGameAns(int[] piles) {
        return true;
    }

}
