package main.java.edu.zju.zjh.lc.oqpd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String key : s1.split(" ")) {
            if (!freq.containsKey(key)) {
                freq.put(key, 1);
            } else {
                freq.put(key, freq.get(key) + 1);
            }
        }

        for (String key : s2.split(" ")) {
            if (!freq.containsKey(key)) {
                freq.put(key, 1);
            } else {
                freq.put(key, freq.get(key) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (value == 1) {
                res.add(key);
            }
        }

        return res.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        for (String s : new Q0884().uncommonFromSentences(s1, s2)) {
            System.out.println(s);
        }
    }
}
