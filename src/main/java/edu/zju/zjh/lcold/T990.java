package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class T990 {

    public void union(int[] us, int x, int y) {
        us[find(us, x)] = find(us, y);
    }

    public int find(int[] us, int x) {
        if (us[x] != x) {
            us[x] = find(us, us[x]);
        }

        return us[x];
    }

    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Character[]> checks = new ArrayList<>();

        int[] us = new int[2 * n];

        for (int i = 0; i < us.length; i++) {
            us[i] = i;
        }

        for (int i = 0; i < equations.length; i++) {
            String str = equations[i];
            char sta = str.charAt(0);
            char end = str.charAt(3);

            if (!map.containsKey(sta)) {
                map.put(sta, arr.size());
                arr.add(sta);
            }
            if (!map.containsKey(end)) {
                map.put(end, arr.size());
                arr.add(end);
            }

            if (str.charAt(1) == '=') {
                union(us, map.get(sta), map.get(end));
            } else {
                Character[] check = new Character[2];
                check[0] = str.charAt(0);
                check[1] = str.charAt(3);
                checks.add(check);
            }
        }


        for (int i = 0; i < checks.size(); i++) {
            Character[] check = checks.get(i);
            int x = map.get(check[0]);
            int y = map.get(check[1]);
            if (find(us, x) == find(us, y)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] equations = new String[6];
//        abcef
        equations[0] = "f==a";
        equations[1] = "a==b";
        equations[2] = "f!=e";
        equations[3] = "a==c";
        equations[4] = "b==e";
        equations[5] = "c!=f";

        System.out.println(new T990().equationsPossible(equations));
    }
}
