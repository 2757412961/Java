package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/15 下午 01:54
 * @Modified_By :
 */
public class T014 {

    public String longestCommonPrefix(String[] strs) {
        Boolean isSame = true;
        int idx = 0;
        if (strs.length <= 0) return "";

        while (idx < strs[0].length() && isSame) {
            char ch = strs[0].charAt(idx);

            for (int i = 1; i < strs.length; i++) {
                if (idx >= strs[i].length() || strs[i].charAt(idx) != ch) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                idx++;
            }
        }

        return strs[0].substring(0, idx);
    }


    public String longestCommonPrefix_Solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.println(new T014().longestCommonPrefix(strs));
        System.out.println(new T014().longestCommonPrefix_Solution(strs));
    }
}
