package main.java.edu.zju.zjh.lcold;

public class T680 {
    public boolean isLoop(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                if (isLoop(s.substring(i + 1, n - i)) || isLoop(s.substring(i, n - 1 - i))) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "abcdceba";

        System.out.println(new T680().validPalindrome(s));
    }
}
