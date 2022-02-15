package edu.zju.zjh.lcold;

public class T1332 {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;

        int i = -1, j = s.length() ;

        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }

        if (i >= j) return 1;

        return 2;
    }

    public static void main(String[] args) {
        String s = "baabb"; // 2 time

        System.out.println(new T1332().removePalindromeSub(s));
    }
}
