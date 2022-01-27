package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/13 上午 09:58
 * @Modified_By :
 */
public class T043 {
    public String add(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        int jin = 0;

        while (i1 >= 0 && i2 >= 0) {
            int n1 = num1.charAt(i1) - '0';
            int n2 = num2.charAt(i2) - '0';

            res.append((n1 + n2 + jin) % 10);
            jin = (n1 + n2 + jin) / 10;

            i1--;
            i2--;
        }

        while (i1 >= 0) {
            int n1 = num1.charAt(i1) - '0';

            res.append((n1 + jin) % 10);
            jin = (n1 + jin) / 10;

            i1--;
        }

        while (i2 >= 0) {
            int n2 = num2.charAt(i2) - '0';

            res.append((n2 + jin) % 10);
            jin = (n2 + jin) / 10;

            i2--;
        }

        if (jin == 1) {
            res.append(jin);
        }

        return res.reverse().toString();
    }

    public String mul(String num1, char num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1, jin = 0;
        int n2 = num2 - '0';
        while (i >= 0) {
            int n1 = num1.charAt(i) - '0';
            int m = n2 * n1 + jin;

            sb.append(m % 10);
            jin = m / 10;

            i--;
        }

        if (jin > 0) {
            sb.append(jin);
        }

        return sb.reverse().toString();
    }

    public String mul(String num1, char num2, int n) {
        StringBuffer sb = new StringBuffer();

        sb.append(mul(num1, num2));

        for (int i = 0; i < n; i++) {
            sb.append(0);
        }

        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        String res = "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(), l2 = num2.length();

        for (int i = 0; i < l2; i++) {
            res = add(res, mul(num1, num2.charAt(i), l2 - i - 1));
        }

        return res;
    }

    public static void main(String[] args) {
//        String num1 = "123";
//        String num2 = "456";

        String num1 = "9133";
        String num2 = "0";

        System.out.println(new T043().multiply(num1, num2));
    }
}
