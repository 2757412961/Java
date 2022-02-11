package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T1371 {
    public Boolean isOdd(int[] fre) {
        for (int i = 0; i < 5; i++) {
            if (fre[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public int findTheLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        int[] fre = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);


        for (int i = 0; i < n; i++) {
            fre = new int[5];
            for (int j = i; j < n; j++) {
                char key = s.charAt(j);
                if (map.containsKey(key)){
                    fre[map.get(key)]++;
                }
                if (isOdd(fre)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";  //  leetminicowor
//        String s = "leetcodeisgreat";  //  leetc
//        String s = "bcbcbc";  //  bcbcbc

        System.out.println(new T1371().findTheLongestSubstring(s));
    }
}
