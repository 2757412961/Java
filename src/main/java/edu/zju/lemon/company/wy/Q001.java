package edu.zju.lemon.company.wy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n3 = n * 3;
        int n4 = n * 4;
        int n7 = n * 7;

        for (int i = 0; i < n4; i++) {
            for (int j = 0; j < n4; j++) {
                if (i < n) {
                    // 前几行
                    if (j < n - i || j >= n3 + i) {
                        System.out.print('.');
                    } else {
                        System.out.print('*');
                    }
                } else if (i >= n3) {
                    // 最后几行
                    if (j <= i - n3 || j >= n7 - i - 1) {
                        System.out.print('.');
                    } else {
                        System.out.print('*');
                    }
                } else {
                    // 中间几行
                    if (j < n || j >= n3) {
                        System.out.print('*');
                    } else {
                        System.out.print('.');
                    }
                }
            }
            System.out.println();
        }
    }
}
