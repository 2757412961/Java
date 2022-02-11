package main.java.edu.zju.zjh.lc.oqpd;

import java.util.Arrays;

public class Q1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] properties = new int[][]{new int[]{1, 5}, new int[]{10, 4}, new int[]{4, 3}};
        System.out.println(new Q1996().numberOfWeakCharacters(properties));
    }

}
