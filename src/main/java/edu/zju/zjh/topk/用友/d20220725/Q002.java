package edu.zju.zjh.topk.用友.d20220725;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/7/25 下午 07:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 数字键按从小到大输出
         *
         * @param str string字符串 包含英文26个字母和@!./标点符号的字符串
         * @return int整型二维数组
         */
        public int[][] count(String str) {
            // write code here
            List<int[]> res = new ArrayList<>();
            int[] cnts = new int[10];
            Map<Character, Integer> map = new HashMap<Character, Integer>() {{
                put('@', 11);
                put('!', 12);
                put('.', 13);
                put('/', 14);
                put('a', 21);
                put('b', 22);
                put('c', 23);
                put('d', 31);
                put('e', 32);
                put('f', 33);
                put('g', 41);
                put('h', 42);
                put('i', 43);
                put('j', 51);
                put('k', 52);
                put('l', 53);
                put('m', 61);
                put('n', 62);
                put('o', 63);
                put('p', 71);
                put('q', 72);
                put('r', 73);
                put('s', 74);
                put('t', 81);
                put('u', 82);
                put('v', 83);
                put('w', 91);
                put('x', 92);
                put('y', 93);
                put('z', 94);
            }};

            for (int i = 0; i < str.length(); i++) {
                Integer num = map.get(str.charAt(i));
                cnts[num / 10] += num % 10;
            }

            for (int i = 0; i < cnts.length; i++) {
                if (cnts[i] > 0) {
                    res.add(new int[]{i, cnts[i]});
                }
            }

            return res.toArray(new int[0][0]);
        }
    }

}
