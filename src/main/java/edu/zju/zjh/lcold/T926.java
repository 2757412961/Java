package main.java.edu.zju.zjh.lcold;

public class T926 {
    public int minFlipsMonoIncr_violence(String S) {
        int res = Integer.MAX_VALUE;
        int n = S.length();
        int oneNum = 0;

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                int count = oneNum;
                for (int j = n - 1; j > i; j--) {
                    if (S.charAt(j) == '0') {
                        count++;
                    }
                }

                oneNum++;
                res = Math.min(res, count);
            }
        }

        int num0 = 0, num1 = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '0') {
                num0++;
            } else {
                num1++;
            }
        }


        return Math.min(res, Math.min(num0, num1));
    }


    public int minFlipsMonoIncr(String S) {
        int res = Integer.MAX_VALUE;
        int n = S.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                for (int j = n - 1; j > i; j--) {
                    if (S.charAt(j) == '0') {
                        count++;
                    }
                }

                res = Math.min(res, count);

                for (int k = i; k < n; k++) {
                    if (S.charAt(k)=='1'){
                        count++;
                    } else {
                        count--;
                        res = Math.min(res, count);
                    }
                }

                break;
            }
        }


        int num0 = 0, num1 = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                num1++;
            } else {
                num0++;
            }
        }


        return Math.min(res, Math.min(num0, num1));
    }

    public static void main(String[] args) {
//        String S = "00100";
//        String S = "00110";
        String S = "0011010";

        System.out.println(new T926().minFlipsMonoIncr(S));
        System.out.println(new T926().minFlipsMonoIncr_violence(S));
    }
}
