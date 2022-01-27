package edu.zju.zjh.lcold;

public class TQPL {
    public static void allra(String s, String out) {
        if (s.length() == out.length()){
            System.out.println(out);
        }

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (out.indexOf(ch) == -1) {
                allra(s, out + s.charAt(i));
            }
        }
    }


    public static void main(String[] args) {
        allra("abc", "");
    }
}
