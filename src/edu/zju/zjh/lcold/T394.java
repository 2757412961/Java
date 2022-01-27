package edu.zju.zjh.lcold;

import java.util.Stack;

public class T394 {
    public String repeatStr(String seg, int repeat) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sb.append(seg);
        }

        return sb.toString();
    }


    public String decodeString_fast(String s) {
        StringBuffer res = new StringBuffer();
        StringBuffer num = new StringBuffer();
        StringBuffer str = new StringBuffer();

        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') num.append(ch);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') str.append(ch);
            if (ch == '[') {
                nums.add(Integer.valueOf(num.toString()));
                num = new StringBuffer();
                strs.add(str.toString());
                str = new StringBuffer();
            }

            if (ch == ']') {
                int repeat = nums.pop();
                String rs = repeatStr(str.toString(), repeat);
                str = new StringBuffer().append(strs.pop()).append(rs);
            }

            if (nums.size() == 0) {
                res.append(str);
                str = new StringBuffer();
            }
        }


        return res.toString();
    }


    public String decodeString(String s) {
        String res = "";
        String num = "";
        String str = "";

        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') num += ch;
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') str += ch;

            if (ch == '[') {
                nums.add(Integer.valueOf(num));
                num = "";
                strs.add(str);
                str = "";
            }

            if (ch == ']') {
                int repeat = nums.pop();
                str = strs.pop() + repeatStr(str, repeat);
            }

            if (nums.size() == 0) {
                res += str;
                str = "";
            }
        }


        return res;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";

        System.out.println(new T394().decodeString(s));
        System.out.println(new T394().decodeString_fast(s));
    }
}
