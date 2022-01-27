package edu.zju.zjh.lc.oqpd;

public class Q2047 {

    public boolean isValidCharacter(char ch) {
        if (ch == ' ') {
            return true;
        } else if ('a' <= ch && ch <= 'z') {
            return true;
        } else if ('0' <= ch && ch <= '9') {
            return true;
        } else if (ch == '-') {
            return true;
        } else if (ch == '!') {
            return true;
        } else if (ch == '.') {
            return true;
        } else if (ch == ',') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidAlpha(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        }
        return false;
    }

    public boolean isValidWord(String str) {
        if (str.length() == 0) {
            return false;
        }
        boolean hasAlpha = false;
        boolean hasConn = false;
        boolean hasPunc = false;

        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if ('0' <= ch && ch <= '9') {
                return false;
            }

            if (ch == '-') {
                if (j >= 1 && isValidAlpha(str.charAt(j - 1)) &&
                        j <= str.length() - 2 && isValidAlpha(str.charAt(j + 1))) {
                } else {
                    return false;
                }

                if (hasConn) {
                    return false;
                }
                hasConn = true;
            }

            if (ch == '!' || ch == '.' || ch == ',') {
                if (str.length() - 1 != j) {
                    return false;
                }
                if (hasPunc) {
                    return false;
                }
                hasPunc = true;
            }
        }

        return true;
    }

    public int countValidWords(String sentence) {
        int res = 0;
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (isValidWord(words[i])) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String sentence = "cat and  dog";
        String sentence2 = "!this  1-s b8d!";
        String sentence3 = "alice and  bob are playing stone-game10";
        String sentence4 = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        String sentence5 = ". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5";

        System.out.println(new Q2047().countValidWords(sentence));
        System.out.println(new Q2047().countValidWords(sentence2));
        System.out.println(new Q2047().countValidWords(sentence3));
        System.out.println(new Q2047().countValidWords(sentence4));
        System.out.println(new Q2047().countValidWords(sentence5));
    }

}
