package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/22 下午 12:52
 * @Modified_By :
 */
public class O1618 {
    public boolean patternMatching(String pattern, String value) {
        int n = pattern.length();
        int l = value.length();
        int leni = 0;
        Boolean firsta = true, firstb = true;
        String stra = "", strb = "";

        int na = 0, nb = 0;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'a') na++;
            else if (pattern.charAt(i) == 'b') nb++;
        }

        if (na == 0 && nb == 0) return value.equals("");
        else if (na == 0 && nb != 0) {
            int lb = l / nb;
            if (nb * lb == l) {
                leni += lb;
                strb = value.substring(0, lb);
                for (int i = 1; i < nb; i++) {
                    if (!strb.equals(value.substring(leni, leni + lb))) {
                        return false;
                    }
                    leni += lb;
                }
                return true;
            }
            return false;
        } else if (na != 0 && nb == 0) {
            int la = l / na;
            if (na * la == l) {
                leni += la;
                strb = value.substring(0, la);
                for (int i = 1; i < na; i++) {
                    if (!strb.equals(value.substring(leni, leni + la))) {
                        return false;
                    }
                    leni += la;
                }
                return true;
            }
            return false;
        }

        int maxla = l / na, len = 0;
        for (int la = 0; la <= maxla; la++) {
            int lb = (l - na * la) / nb;
            if (na * la + nb * lb == l) {
                len = 0;
                firsta = true;
                firstb = true;
                int i = 0;
                for (; i < n; i++) {
                    if (pattern.charAt(i) == 'a') {
                        if (firsta) {
                            stra = value.substring(len, len + la);
                            firsta = false;
                        }
                        if (!stra.equals(value.substring(len, len + la))) {
                            break;
                        }
                        len += la;
                    } else if (pattern.charAt(i) == 'b') {
                        if (firstb) {
                            strb = value.substring(len, len + lb);
                            firstb = false;
                        }
                        if (!strb.equals(value.substring(len, len + lb))) {
                            break;
                        }
                        len += lb;
                    }
                }
                if (i == n && !stra.equals(strb)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式
//        例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
//        但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。


//        String pattern = "abba";
//        String value = "dogcatcatdog";
//        String pattern = "bbbb";
//        String value = "dogdogdogdog";
//        String pattern = "abba";
//        String value = "dogdogdogdog";
//        String pattern = "";
//        String value = "";
//        String pattern = "bbbaa";
//        String value = "xxxxxxy";
        String pattern = "bbaba";
        String value = "ajocitdfyhohchqvilvdjjocitdfyhohchqvilvdj";

        System.out.println(new O1618().patternMatching(pattern, value));
    }
}
