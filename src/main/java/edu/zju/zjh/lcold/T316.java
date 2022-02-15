package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Stack;

public class T316 {

    public String removeDuplicateLetters(String s) {
        String res = "";
        ArrayList<Character> slist = new ArrayList<>();
        Stack<Character> miniorder = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            slist.add(s.charAt(i));
        }

        while (slist.size() > 0){
            char ch = slist.get(0);
            slist.remove(0);

            if (miniorder.contains(ch)) {
                continue;
            }

            while (!miniorder.isEmpty() &&
                    miniorder.peek() > ch &&
                    slist.contains(miniorder.peek())){
                miniorder.pop();
            }
            miniorder.push(ch);
        }

        for (int ri = 0; ri < miniorder.size(); ri++) {
            res = res + miniorder.get(ri);
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "abacb";

        T316 t316 = new T316();
        System.out.println(t316.removeDuplicateLetters(s));
    }
}
