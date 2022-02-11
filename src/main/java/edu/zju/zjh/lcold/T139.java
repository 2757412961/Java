package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/25 下午 08:52
 * @Modified_By :
 */
public class T139 {
    public boolean digui(String s, int idx, Map<String, Boolean> map) {
        StringBuffer sb = new StringBuffer();
        Boolean flag = false;

        if (idx >= s.length()) return true;

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (map.containsKey(sb.toString())) {
                flag = flag || digui(s, i + 1, map);
            }
        }

        return flag;
    }


    public boolean wordBreak_violence(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }

        return digui(s, 0, map);
    }

    public boolean digui_2(String s, int idx, Map<String, Boolean> map, Boolean[] ok) {
        StringBuffer sb = new StringBuffer();
        Boolean flag = false;

        if (idx >= s.length()) return true;
        if (ok[idx] != null) return ok[idx];

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (map.containsKey(sb.toString())) {
                ok[i] = digui_2(s, i + 1, map, ok);
                flag = flag || ok[i];
            }
        }

        return flag;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean[] ok = new Boolean[s.length()];

        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }

        return digui_2(s, 0, map, ok);
    }

    public static void main(String[] args) {
//        给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//        说明：//
//        拆分时可以重复使用字典中的单词。
//        你可以假设字典中没有重复的单词。
//
//        示例 1：
//        输入: s = "leetcode", wordDict = ["leet", "code"]
//        输出: true
//        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//        示例 2：
//        输入: s = "applepenapple", wordDict = ["apple", "pen"]
//        输出: true
//        解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//        示例 3：
//        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        输出: false
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//                ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");

        System.out.println(new T139().wordBreak(s, wordDict));
        System.out.println(new T139().wordBreak_violence(s, wordDict));

    }
}
