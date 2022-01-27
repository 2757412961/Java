package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:17
 * @Modified_By :
 */
public class T392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int si = 0, ti = 0;

        while (si < m && ti < n) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }

            ti++;
        }

        return si == m;
    }

    public static void main(String[] args) {
//        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。/
//        你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。/
//        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//        示例 1:
//        s = "abc", t = "ahbgdc"
//        返回 true.
//
//        示例 2:
//        s = "axc", t = "ahbgdc"
//        返回 false

        String s = "abc";
        String t = "ahbgdcx";

        System.out.println(new T392().isSubsequence(s, t));
    }
}
