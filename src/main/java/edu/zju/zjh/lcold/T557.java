package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/30 上午 01:23
 * @Modified_By :
 */
public class T557 {
    public String reverseWords(String s) {
        if (s.equals("")) return "";
        String res = "";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.insert(0, ' ');
                res += sb.reverse().toString();
                sb = new StringBuffer();
            } else {
                sb.append(ch);
            }
        }

        if (sb.capacity() >= 0) {
            sb.insert(0, ' ');
            res += sb.reverse().toString();
        }

        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
//        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//        示例：
//        输入："Let's take LeetCode contest"
//        输出："s'teL ekat edoCteeL tsetnoc"

        String s = "Let's take LeetCode contes";

        System.out.println(new T557().reverseWords(s));
    }
}
