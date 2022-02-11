package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/29 上午 10:36
 * @Modified_By :
 */
public class T214 {
    public int[] loopPos(String s, int left, int righ) {
        int n = s.length();

        while (0 <= left && righ < n && s.charAt(left) == s.charAt(righ)) {
            left--;
            righ++;
        }

        left++;
        righ--;

        int[] pos = new int[]{left, righ};
        return pos;
    }

    public String shortestPalindrome_violence(String s) {
        if (s.equals("")) return s;
        int n = s.length();
        String res = new StringBuffer(s).reverse().substring(0, n - 1);
        int[] pos = null;

        for (int i = 0; i < n / 2; i++) {
            pos = loopPos(s, i, i);
            if (pos[0] == 0) {
                int l = n - 1 - pos[1];
                if (l < res.length()) {
                    res = new StringBuffer(s.substring(pos[1] + 1)).reverse().toString();
                }
            }

            if (s.charAt(i) == s.charAt(i + 1)) {
                pos = loopPos(s, i, i + 1);
                if (pos[0] == 0) {
                    int l = n - 1 - pos[1];
                    if (l < res.length()) {
                        res = new StringBuffer(s.substring(pos[1] + 1)).reverse().toString();
                    }
                }
            }
        }

        return res + s;
    }

    public String shortestPalindrome(String s) {


        return "";
    }

    public static void main(String[] args) {

//        给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
//
//        示例 1:
//        输入: "aacecaaa"
//        输出: "aaacecaaa"

//        示例 2:
//        输入: "abcd"
//        输出: "dcbabcd"

//        String s = "aacecaaa";
//        String s = "abcd";
//        String s = "abad";
        String s = "abbad";

        System.out.println(new T214().shortestPalindrome(s));
        System.out.println(new T214().shortestPalindrome_violence(s));
    }
}
