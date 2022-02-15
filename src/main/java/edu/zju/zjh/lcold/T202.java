package edu.zju.zjh.lcold;

import java.util.HashSet;
import java.util.Set;

public class T202 {
    public int happy(int n) {
        int hap = 0;

        while (n > 0) {
            int rest = n % 10;
            hap += rest * rest;
            n /= 10;
        }

        return hap;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = happy(n);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T202().isHappy(19));
    }
}
