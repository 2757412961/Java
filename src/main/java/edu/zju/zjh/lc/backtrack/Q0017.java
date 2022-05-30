package edu.zju.zjh.lc.backtrack;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/5/30 9:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0017 {

    /**
     * 官方
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了54.43% 的Java用户
     */
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
            return combinations;
        }

        public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    }

    /**
     * 方法一：回溯
     * 执行耗时:1 ms,击败了49.44% 的Java用户
     * 内存消耗:39.8 MB,击败了74.37% 的Java用户
     */
    private List<String> res = new LinkedList<>();
    private StringBuilder path = new StringBuilder();
    private Map<Character, char[]> map = new HashMap<Character, char[]>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public void backTrack(char[] digits, int pos) {
        if (pos == digits.length) {
            res.add(path.toString());
            return;
        }

        final char[] chars = map.get(digits[pos]);
        for (char c : chars) {
            path.append(c);
            backTrack(digits, pos + 1);
            path.deleteCharAt(pos);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return res;
        backTrack(digits.toCharArray(), 0);
        return res;
    }

    public static void main(String[] args) {
        new Q0017().letterCombinations("23").stream().forEach(System.out::println);
    }

}
