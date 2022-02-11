package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/24 上午 01:09
 * @Modified_By :
 */
public class T459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        char last = s.charAt(n - 1);

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == last && n % (i + 1) == 0) {
                String val = s.substring(0, i + 1);
                int tmpi = i + 1;
                while (tmpi < n && val.equals(s.substring(tmpi, tmpi + val.length()))) {
                    tmpi += val.length();
                }
                if (tmpi == n) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
//        示例 1:
//        输入: "abab"
//        输出: True
//        解释: 可由子字符串 "ab" 重复两次构成。
//
//        示例 2:
//        输入: "aba"
//        输出: False
//
//        示例 3:
//        输入: "abcabcabcabc"
//        输出: True
//        解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)

//        String s = "abab";
        String s = "abc";

        System.out.println(new T459().repeatedSubstringPattern(s));
    }
}
