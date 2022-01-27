package edu.zju.zjh.lcold;

import java.util.*;

public class T076 {
    public String minWindow_violence(String s, String t) {
        String res = "";
        boolean flag = true;
        for (int i = 0; i < 9999; i++) {
            res += " ";
        }

        ArrayList<Character> tset = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (t.indexOf(s.charAt(i)) < 0) {
                continue;
            }

            for (int ti = 0; ti < t.length(); ti++) {
                tset.add(t.charAt(ti));
            }

            int j = i;
            for (; j < s.length() && tset.size() > 0; j++) {
                char ch = s.charAt(j);
                if (tset.contains(ch)) {
                    tset.remove(tset.indexOf(ch));
                }
            }

            if (tset.size() == 0 && res.length() > j - i) {
                res = s.substring(i, j);
                flag = false;
            }
        }

        if (flag) {
            res = "";
        }

        return res;
    }

    public String minWindow_ArrayList(String s, String t) {
        String res = "";
        boolean flag = true;
        for (int ri = 0; ri < 9999; ri++) res += " ";
        int sta = 0, end = 0;
        ArrayList<Character> set = new ArrayList<>();
        ArrayList<Character> more = new ArrayList<>();

        for (int ti = 0; ti < t.length(); ti++) {
            set.add(t.charAt(ti));
        }

        while (sta < s.length() && end < s.length()) {
            while (end < s.length() && set.size() > 0) {
                char ch = s.charAt(end);
                if (t.indexOf(ch) >= 0 && !set.contains(ch)) {
                    more.add(ch);
                }

                if (set.contains(ch)) {
                    set.remove(set.indexOf(ch));
                }
                end++;
            }

            if (set.size() == 0 && res.length() > end - sta) {
                res = s.substring(sta, end);
                flag = false;
            }

            while (sta < s.length() && set.size() <= 0) {
                if (set.size() == 0 && res.length() > end - sta) {
                    res = s.substring(sta, end);
                    flag = false;
                }

                char ch = s.charAt(sta);
                if (more.contains(ch)) {
                    more.remove(more.indexOf(ch));
                } else {
                    if (t.indexOf(ch) >= 0) {
                        set.add(ch);
                    }
                }

                sta++;
            }
        }

        if (flag) {
            res = "";
        }

        return res;
    }

    public static String minWindow_version01(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> stat = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!tmap.containsKey(ch)) {
                tmap.put(ch, 1);
                stat.put(ch, 0);
            } else {
                tmap.put(ch, tmap.get(ch) + 1);
            }
        }

        int count = 0, countN = tmap.size();
        int i = 0, j = 0, n = s.length();
        while (j < n && i < n) {
            while (count < countN && j < n) {
                char ch = s.charAt(j++);
                if (stat.containsKey(ch)) {
                    int ch_count = stat.get(ch) + 1;
                    stat.put(ch, ch_count);

                    if (ch_count == tmap.get(ch)) {
                        count++;
                    }
                }
            }

            if (count == countN && j - i < right - left) {
                left = i;
                right = j;
            }

            while (count >= countN && i < n) {
                char ch = s.charAt(i++);
                if (stat.containsKey(ch)) {
                    int ch_count = stat.get(ch) - 1;
                    stat.put(ch, ch_count);

                    if (ch_count < tmap.get(ch)) {
                        count--;
                        break;
                    }
                }
                if (count == countN && j - i < right - left) {
                    left = i;
                    right = j;
                }
            }
        }

        return (right - left < Integer.MAX_VALUE) ? s.substring(left, right) : "";
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        T076 t076 = new T076();
        System.out.println(t076.minWindow(s, t));
        System.out.println(t076.minWindow_version01(s, t));
        System.out.println(t076.minWindow_ArrayList(s, t));
        System.out.println(t076.minWindow_violence(s, t));
    }
}
