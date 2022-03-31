package edu.zju.zjh.lc.string;

public class Q0345 {

    public boolean isYuanyin(char ch) {
        if (ch == 'a' || ch == 'A') return true;
        if (ch == 'e' || ch == 'E') return true;
        if (ch == 'i' || ch == 'I') return true;
        if (ch == 'o' || ch == 'O') return true;
        if (ch == 'u' || ch == 'U') return true;
        return false;
    }

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !isYuanyin(chars[i])) {
                i++;
            }
            while (i < j && !isYuanyin(chars[j])) {
                j--;
            }

            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
            i++;
            j--;
        }

        return new String(chars);
    }

}
