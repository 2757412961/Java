package edu.zju.zjh.lc.string;

import java.util.List;

/**
 * @author: zjh
 * @date : 2022/6/5 11:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0139 {

    /**
     * 递归+记忆化搜索
     * <p>
     * 执行耗时:1 ms,击败了99.71% 的Java用户
     * 内存消耗:39.6 MB,击败了92.89% 的Java用户
     */
    private boolean res = false;
    private boolean[] memo;

    public boolean trackBack(String s, int sid, List<String> wordDict) {
        if (res) return res;
        if (sid == s.length()) return true;
        if (sid > s.length()) return false;
        if (memo[sid]) return false;

        for (String word : wordDict) {
            if (s.startsWith(word, sid)) {
                res |= trackBack(s, sid + word.length(), wordDict);
                memo[sid] = true;
            }
        }

        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new boolean[s.length()];
        return trackBack(s, 0, wordDict);
    }

}
