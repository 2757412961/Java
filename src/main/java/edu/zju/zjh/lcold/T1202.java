package main.java.edu.zju.zjh.lcold;

import java.util.*;

public class T1202 {
    int[] us;

    public int find(int x) {
        if (us[x] == x) {
            return x;
        }

        return us[x] = find(us[x]);
    }

    public void union(int x, int y) {
        us[find(y)] = find(x);
    }


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        String res = "";
        int n = s.length();
        us = new int[n];
        char[] chars = new char[n];
        int[] used = new int[n];
        ArrayList<Integer> indexs = new ArrayList<>();
        Map<Integer, Queue<Character>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            us[i] = i;
        }

        for (int i = 0; i < pairs.size(); i++) {
            union(pairs.get(i).get(0), pairs.get(i).get(1));
        }

        for (int i = 0; i < n; i++) {
            int key = find(i);
            if (!map.containsKey(key)){
                map.put(key, new PriorityQueue<>());
            }
            map.get(find(i)).add(s.charAt(i));
        }


        for (int k = 0; k < n; k++) {
            chars[k] = map.get(find(k)).poll();
        }


        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(new Integer[]{0, 2})));
        pairs.add(new ArrayList<>(Arrays.asList(new Integer[]{2, 3})));

        System.out.println(new T1202().smallestStringWithSwaps(s, pairs));
    }
}
