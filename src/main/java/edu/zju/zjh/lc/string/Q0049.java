package edu.zju.zjh.lc.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zjh
 * @date : 2022/5/30 9:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0049 {


    /**
     * 方法一：排序
     * <p>
     * 执行耗时:6 ms,击败了78.38% 的Java用户
     * 内存消耗:44.4 MB,击败了54.07% 的Java用户
     */
    public List<List<String>> groupAnagramsSort(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, new LinkedList<>());
            }
            map.get(s).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    /**
     * 方法二：计数
     * <p>
     * 执行耗时:16 ms,击败了12.48% 的Java用户
     * 内存消耗:44.5 MB,击败了32.80% 的Java用户
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            // 初始化
            Arrays.fill(count, 0);
            sb = new StringBuilder();

            // 编码
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
            }
            // 整型数组转字符串
            for (int j = 0; j < count.length; j++) {
                sb.append(count[j]).append(',');
            }

            // 相同key归为一类
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }

}
