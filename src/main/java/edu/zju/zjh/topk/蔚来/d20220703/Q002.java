package edu.zju.zjh.topk.蔚来.d20220703;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/7/3 下午 07:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static boolean judgeSimple(List<Integer> t) {
        return (t.get(0) + t.get(1)) > t.get(2);
    }

    public static boolean judgeTri(int[] arr, boolean[] used) {
        List<Integer> t1 = new ArrayList<>(3);
        List<Integer> t2 = new ArrayList<>(3);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    t1.clear();
                    t2.clear();
                    for (int l = 0; l < arr.length; l++) {
                        if (l == i || l == j || l == k) {
                            t1.add(arr[l]);
                        } else {
                            t2.add(arr[l]);
                        }
                    }
                    if (judgeSimple(t1) && judgeSimple(t2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[6];
            boolean[] used = new boolean[6];

            for (int j = 0; j < 6; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);
//            swap(arr, 0, 5);
//            swap(arr, 1, 4);
//            swap(arr, 2, 3);

            if (judgeTri(arr, used)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
