package edu.zju.zjh.lcold;

public class T010 {
    /*

    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素

     */
    public boolean match2(String s, String p, int x, int y) {
        if (x >= s.length() && y >= p.length()) {
            return true;
        } else if (x < s.length() && y >= p.length() || x >= s.length() && y < p.length()) {
            return false;
        }

        Boolean falg = s.charAt(x) == p.charAt(y) || p.charAt(y) == '.';

        if (p.length() > y + 1 && p.charAt(y + 1) == '*') {
            return falg && match2(s, p, x + 1, y) || match2(s, p, x, y + 2);
        } else {
            return falg && match2(s, p, x + 1, y + 1);
        }
    }


    public boolean isMatch_myIdea(String s, String p) {
        return match2(s, p, 0, 0);
    }


    public boolean match(String s, String p, int x, int y) {
        if (y >= p.length()) return x >= s.length();

        Boolean falg = x < s.length() && (s.charAt(x) == p.charAt(y) || p.charAt(y) == '.');

        if (p.length() > y + 1 && p.charAt(y + 1) == '*') {
            return falg && match(s, p, x + 1, y) || match(s, p, x, y + 2);
        } else {
            return falg && match(s, p, x + 1, y + 1);
        }
    }


    public boolean isMatch_official(String s, String p) {
        return match(s, p, 0, 0);
    }


    public Boolean match_0620(String s, String p, int si, int pi) {
        Boolean flag;
        if (si >= s.length() && pi >= p.length()) {
            return true;
        } else if (si < s.length() && pi >= p.length()) {
            return false;
        } else if (si >= s.length() && pi < p.length()) {
            flag = false;
        } else {
            flag = s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.';
        }

        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            return flag && match_0620(s, p, si + 1, pi) ||
                    match_0620(s, p, si, pi + 2);
        } else {
            return flag && match_0620(s, p, si + 1, pi + 1);
        }
    }

    public boolean isMatch(String s, String p) {
        return match_0620(s, p, 0, 0);
    }

    public static void main(String[] args) {
//        String s = "aa";
//        String p = "a*";
        String s = "aa";
        String p = ".*c";
//        String s = "aaouyoi";
//        String p = ".*";

        System.out.println(new T010().isMatch(s, p));
        System.out.println(new T010().isMatch_official(s, p));
        System.out.println(new T010().isMatch_myIdea(s, p));
    }
}
