package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/19 下午 06:30
 * @Modified_By :
 */
public class T125 {
    public boolean isPalindrome(String s) {
        int sta = 0, end = s.length() - 1;
        s = s.toLowerCase();

        while (sta < end) {
            char chsta = s.charAt(sta);
            char chend = s.charAt(end);
            while (sta < end && !('a' <= chsta && chsta <= 'z' || '0' <= chsta && chsta <= '9')) {
                sta++;
                chsta = s.charAt(sta);
            }

            while (sta < end && !('a' <= chend && chend <= 'z' || '0' <= chend && chend <= '9')) {
                end--;
                chend = s.charAt(end);
            }

            if (chsta != chend) {
                return false;
            }
            sta++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a pan, a canal: Panama";
//        String s = ",.";
        String s = "0P";

        System.out.println(new T125().isPalindrome(s));
    }
}
