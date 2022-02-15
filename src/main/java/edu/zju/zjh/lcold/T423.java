package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T423 {
    public String originalDigits_official(String s) {
        // building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < out[i]; j++)
                output.append(i);
        return output.toString();
    }

    public String originalDigits(String s) {
        StringBuffer sb = new StringBuffer();
        int[] cons = new int[10];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // zero 0
        // one 1
        // two 2
        // three 3
        // four 4
        // five 5
        // six 6
        // seven 7
        // eight 8
        // nine
        cons[0] = map.getOrDefault('z', 0);
        cons[2] = map.getOrDefault('w', 0);
        cons[4] = map.getOrDefault('u', 0);
        cons[6] = map.getOrDefault('x', 0);
        cons[8] = map.getOrDefault('g', 0);

        cons[1] = map.getOrDefault('o', 0)
                - cons[0] - cons[2] - cons[4];
        cons[3] = map.getOrDefault('t', 0)
                - cons[2] - cons[8];
        cons[5] = map.getOrDefault('f', 0)
                - cons[4];
        cons[7] = map.getOrDefault('v', 0)
                - cons[5];
        cons[9] = map.getOrDefault('i', 0)
                - cons[5] - cons[6] - cons[8];

        for (int i = 0; i < cons.length; i++) {
            for (int j = 0; j < cons[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "owoztneoer";

        System.out.println(new T423().originalDigits(s));
        System.out.println(new T423().originalDigits_official(s));
    }
}
