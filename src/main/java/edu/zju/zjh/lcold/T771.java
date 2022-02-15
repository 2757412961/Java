package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T771 {
    public int numJewelsInStones(String J, String S) {
        int res = 0;

        Map<Character, Boolean> baos = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            char ch = J.charAt(i);
            if (!baos.containsKey(ch)) {
                baos.put(ch, true);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (baos.containsKey(S.charAt(i))) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
//         S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//        J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//
//        示例 1:
//        输入: J = "aA", S = "aAAbbbb"
//        输出: 3
//
//        示例 2:
//        输入: J = "z", S = "ZZ"
//        输出: 0

        String J = "aS";
        String S = "aAAbbbbb";
        System.out.println(new T771().numJewelsInStones(J, S));
    }
}
