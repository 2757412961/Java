package edu.zju.zjh.lc.doublepointer.leftright;

public class Q0125 {

    public boolean isValid(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        }
        if ('A' <= ch && ch <= 'Z') {
            return true;
        }
        if ('0' <= ch && ch <= '9') {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < s.length() && !isValid(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isValid(s.charAt(j))) {
                j--;
            }
            if (i >= j) break;
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
        }

        return true;
    }

}
