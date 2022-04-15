package edu.zju.zjh.lc.ds.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/15 上午 11:18
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0050 {

    public char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();

        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() == 1) return next.getKey();
        }

        return ' ';
    }

}
