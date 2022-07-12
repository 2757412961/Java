package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/7/12 21:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
