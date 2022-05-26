package edu.zju.zjh.lc.string.brackets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/5/14 17:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0020 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.offerLast(c);
            } else if (!map.get(c).equals(stack.pollLast())) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
