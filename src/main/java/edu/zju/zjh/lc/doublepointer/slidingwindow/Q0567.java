package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/8 17:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        int start = -1, len = Integer.MAX_VALUE;

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        while (right < s2.length()) {
            char chr = s2.charAt(right++);
            if (window.containsKey(chr)) {
                window.put(chr, window.get(chr) + 1);
                if (window.get(chr).equals(need.get(chr))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char chl = s2.charAt(left++);
                if (window.containsKey(chl)) {
                    if (window.get(chl).equals(need.get(chl))) {
                        valid--;
                    }
                    window.put(chl, window.get(chl) - 1);
                }
            }
        }

        return false;
    }

}
