package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/26 下午 03:09
 * @Modified_By :
 */
public class T017 {
    List<String> res = new ArrayList<>();

    public void huishu(Map<Character, Character[]> map, String digitd, int pos, String ans) {
        if (pos >= digitd.length()) {
            res.add(ans);
            return;
        }

        Character[] chars = map.get(digitd.charAt(pos));
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            huishu(map, digitd, pos + 1, ans + ch);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();

        Map<Character, Character[]> map = new HashMap();
        map.put('0', new Character[0]);
        map.put('1', new Character[0]);
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        huishu(map, digits, 0, "");

        return res;
    }

    public static void main(String[] args) {
//        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//        示例:
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

        String digits = "23";
        System.out.println(new T017().letterCombinations(digits));
    }
}
