package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/5/28 13:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0043 {

    /**
     * 方法一：做加法 时间复杂度：O(mn+n^2)
     * 执行耗时:13 ms,击败了37.86% 的Java用户
     * 内存消耗:41.6 MB,击败了40.50% 的Java用户
     */
    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 && j >= 0) {
            int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + flag;
            sb.append(sum % 10);
            flag = sum / 10;
        }

        while (i >= 0) {
            int sum = num1.charAt(i--) - '0' + flag;
            sb.append(sum % 10);
            flag = sum / 10;
        }

        while (j >= 0) {
            int sum = num2.charAt(j--) - '0' + flag;
            sb.append(sum % 10);
            flag = sum / 10;
        }

        if (flag > 0) sb.append(flag);

        return sb.reverse().toString();
    }

    public StringBuilder multiplySingle(String num, int c) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int sum = (num.charAt(i) - '0') * c + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse();
    }

    public String multiplyAdd(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0", endZero = "";

        for (int j = num2.length() - 1; j >= 0; j--) {
            int c = num2.charAt(j) - '0';
            if (c != 0) {
                StringBuilder sb = multiplySingle(num1, c);
                sb.append(endZero);
                res = add(res, sb.toString());
            }
            endZero = endZero + '0';
        }

        return res;
    }

    /**
     * 方法二：做乘法 时间复杂度：O(mn)
     * 执行耗时:9 ms,击败了40.81% 的Java用户
     * 内存消耗:41.5 MB,击败了48.00% 的Java用户
     */
    public void add2ans(int[] ans, int idx, int x) {
        int sum = 0;
        while (idx < ans.length && x != 0) {
            sum = ans[idx] + x;
            ans[idx] = sum % 10;
            x = sum / 10;
            idx++;
        }
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        int[] ans = new int[m + n];

        // 初始化，转换为整形数组
        for (int i = 0; i < m; i++) {
            nums1[i] = num1.charAt(m - 1 - i) - '0';
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = num2.charAt(n - 1 - i) - '0';
        }

        // 遍历相乘
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = nums1[i] * nums2[j];
                add2ans(ans, i + j, sum % 10);
                add2ans(ans, i + j + 1, sum / 10);
            }
        }

        // 将ans数组转成字符串
        int idx = ans.length - 1, c = 0;
        StringBuilder sb = new StringBuilder();
        while (idx >= 0) {
            c = ans[idx--];
            // 除去前导0
            if (sb.length() == 0 && c == 0) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q0043().multiplyAdd("9133", "0"));
        System.out.println(new Q0043().multiply("9133", "0"));
        System.out.println(new Q0043().multiplyAdd("0", "98540"));
        System.out.println(new Q0043().multiply("0", "98540"));
        System.out.println(new Q0043().multiplyAdd("103", "405"));
        System.out.println(new Q0043().multiply("103", "405"));
    }

}
