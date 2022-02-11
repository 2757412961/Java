package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class O038 {
    Set<String> set;
    ArrayList<Character> ar;
    int[] used;
    int n;

    public void hs(String s) {
        if (ar.size() == n) {
            StringBuffer strb = new StringBuffer();

            for (int i = 0; i < ar.size(); i++) {
                strb.append(ar.get(i));
            }
            set.add(strb.toString());

            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                ar.add(s.charAt(i));
                hs(s);
                ar.remove(ar.size() - 1);
                used[i] = 0;
            }
        }
    }

    public String[] permutation(String s) {
        set = new HashSet<>();
        ar = new ArrayList<>();
        n = s.length();
        used = new int[n];

        hs(s);

        int index = 0;
        String[] res = new String[set.size()];
        for (String str : set) {
            res[index++] = str;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aac";

        new O038().permutation(s);
    }
}
