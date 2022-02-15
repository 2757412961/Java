package edu.zju.zjh.lcold;

public class T984 {
    public String strWithout3a3b(int A, int B) {
        String res = "";
        char ch1 = 'a';
        char ch2 = 'b';

        if (B > A) {
            ch1 = 'b';
            ch2 = 'a';
            int temp = A;
            A = B;
            B = temp;
        }

        int lim = A - 2 * B;
        if (lim >= 0) {
            for (int i = 0; i < B; i++) {
                res += ch1;
                res += ch1;
                res += ch2;
            }

            for (int i = 0; i < lim; i++) {
                res += ch1;
            }
        } else {
            lim = A - B;
            boolean flag = true;

            for (int i = 0; i < lim; i++) {
                res += ch1;
                res += ch1;
                res += ch2;
                A -= 2;
                B -= 1;
            }

            while (A > 0 || B > 0) {
                if (flag) {
                    res += ch1;
                    A -= 1;
                } else {
                    res += ch2;
                    B -= 1;
                }
                flag = !flag;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 5;

        System.out.println(new T984().strWithout3a3b(A, B));
    }
}
