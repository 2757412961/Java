package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/2 上午 12:18
 * @Modified_By :
 */
public class T306 {
    public String add(String num1, String num2) {
        if (num1.length() >= 2 && num1.charAt(0) == '0' || num2.length() >= 2 && num2.charAt(0) == '0') return "-";

        int l1 = num1.length() - 1, l2 = num2.length() - 1, res = 0;
        StringBuffer sb = new StringBuffer();

        while (l1 >= 0 && l2 >= 0) {
            int sum = num1.charAt(l1) - '0' + num2.charAt(l2) - '0' + res;
            res = sum / 10;

            sb.append(sum % 10);
            l1--;
            l2--;
        }

        while (l1 >= 0) {
            int sum = num1.charAt(l1) - '0' + res;
            res = sum / 10;

            sb.append(sum % 10);
            l1--;
        }

        while (l2 >= 0) {
            int sum = num2.charAt(l2) - '0' + res;
            res = sum / 10;

            sb.append(sum % 10);
            l2--;
        }

        if (res > 0) sb.append(res);

        return sb.reverse().toString();
    }

    public boolean judge(String num, int id1, int id2) {
        int n = num.length();
        int id = id2;
        String a = num.substring(0, id1);
        String b = num.substring(id1, id2);
        String c = add(a, b);

        while (id + c.length() <= n) {
            if (!c.equals(num.substring(id, id + c.length()))) {
                return false;
            }
            id += c.length();
            a = b;
            b = c;
            c = add(a, b);
        }

        return id == n;
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                if (judge(num, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        306. 累加数
//        累加数是一个字符串，组成它的数字可以形成累加序列。
//
//        一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
//        给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
//        说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

//        示例 1:
//        输入: "112358"
//        输出: true
//        解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

//        示例 2:
//        输入: "199100199"
//        输出: true
//        解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

        String num = "199100199";

        System.out.println(new T306().isAdditiveNumber(num));
    }
}
