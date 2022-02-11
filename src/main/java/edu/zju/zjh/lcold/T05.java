package main.java.edu.zju.zjh.lcold;

public class T05 {
    public Boolean isloop(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public String longestPalindrome_violence(String s) {
        String res = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (isloop(s.substring(i, j))) {
                    if (j - i > res.length()) {
                        res = s.substring(i, j);
                    }
                    break;
                }
            }
        }

        return res;
    }

    int n;
    char[] chars;


    public int loopnum(int left, int right) {
        int step = 0;

        while (left >= 0 && right < n && chars[left] == chars[right]) {
            left--;
            right++;
            step++;
        }

        return step;
    }

    public String longestPalindrome(String s) {
        String res = "";
        n = s.length();
        chars = s.toCharArray();

        if (n <= 0) return "";

        int sta = -1, end = -2;
        for (int i = 0; i < n; i++) {
            int step1 = loopnum(i, i);
            int step2 = loopnum(i, i + 1);

            int l = n;
            int r = 0;

            if (step1 > 0) {
                step1 -= 1;
                l = Math.min(l, i - step1);
                r = Math.max(r, i + step1);
            }
            if (step2 > 0) {
                step2 -= 1;
                l = Math.min(l, i - step2);
                r = Math.max(r, i + step2 + 1);
            }


            if (end - sta < r - l) {
                sta = l;
                end = r;
            }
        }

        res = String.valueOf(chars, sta, end - sta + 1);

        return res;
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(new T05().longestPalindrome(s));
        System.out.println(new T05().longestPalindrome_violence(s));
    }
}
