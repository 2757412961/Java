package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/6 下午 12:31
 * @Modified_By :
 */
public class T336 {
    public boolean isloop(String str) {
        int l = 0, r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs_violence(String[] words) {
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String str = words[i] + words[j];
                    if (isloop(str)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        res.add(temp);
                    }
                }
            }
        }

        return res;
    }

    public boolean isloop(String s, String t) {
        int l = 0, r = t.length() - 1;

        while (l < s.length() && r >= 0) {
            if (s.charAt(l) != t.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        if (l < s.length()) {
            return isloop(s.substring(l, s.length()));
        }

        if (r >= 0) {
            return isloop(t.substring(0, r + 1));
        }

        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isloop(words[i], words[j])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
                if (isloop(words[j], words[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
//
//        示例 1:
//        输入: ["abcd","dcba","lls","s","sssll"]
//        输出: [[0,1],[1,0],[3,2],[2,4]]
//        解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
//
//        示例 2:
//        输入: ["bat","tab","cat"]
//        输出: [[0,1],[1,0]]
//        解释: 可拼接成的回文串为 ["battab","tabbat"]

        String[] words = new String[]{
                "abcd",
                "dcba",
                "lls",
                "s",
                "sssll"
        };

        System.out.println(new T336().palindromePairs(words));
        System.out.println(new T336().palindromePairs_violence(words));
    }
}
