package edu.zju.lemon.company.ali;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[t];

        for (int i = 0; i < t; i++) {
            strs[i] = sc.nextLine();
        }

        Set<String> set = new HashSet<>(t);
        for (int i = 0; i < t; i++) {
            if (strs[i].length() > 12 || strs[i].length() < 6) {
                System.out.println("illegal length");
            } else if (!strs[i].matches("^[a-zA-Z]+$")) {
                System.out.println("illegal charactor");
            } else if (set.contains(strs[i])) {
                System.out.println("acount existed");
            } else {
                System.out.println("registration complete");
                set.add(strs[i]);
            }
        }
    }
}
