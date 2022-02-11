package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/19 下午 01:08
 * @Modified_By :
 */
public class T647 {
    public boolean isloop(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public int countSubstrings_violence(String s) {
        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isloop(s.substring(i, j + 1))) {
                    res++;
                }
            }
        }

        return res;
    }

    public int conloop(String s, int l, int r) {
        int con = 0;

        while (0 <= l && r < s.length()) {
            if (s.charAt(l--) != s.charAt(r++)) {
                return con;
            }
            con++;
        }

        return con;
    }

    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += conloop(s, i, i);
            res += conloop(s, i, i + 1);
        }

        return res;
    }


    public static void main(String[] args) {
//        给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//        示例 1：
//        输入："abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//
//        示例 2：
//        输入："aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


        String s = "abc";
//        String s = "aaa";

        System.out.println(new T647().countSubstrings(s));
        System.out.println(new T647().countSubstrings_violence(s));
    }
}
