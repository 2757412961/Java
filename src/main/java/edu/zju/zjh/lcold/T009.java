package edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T009 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int copy = x;
        int n = 0;
        int idx;
        ArrayList<Integer> arr = new ArrayList<>();

        do {
            n++;
            arr.add(copy % 10);
            copy /= 10;
        } while (copy > 0);

        idx = n - 1;
        n /= 2;
        while (n-- >= 0) {
            if (arr.get(idx--) != x % 10) {
                return false;
            }
            x /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        int x = 121;

        System.out.println(new T009().isPalindrome(x));
    }
}
