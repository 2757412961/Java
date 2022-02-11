package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/10 下午 03:10
 * @Modified_By :
 */
public class T696 {
    public int countBinarySubstrings_violence(String s) {
        int res = 0;
        int same, nots;
        boolean change;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            change = false;
            same = 1;
            nots = 0;
            for (int j = i + 1; j < s.length(); j++) {
                char next = s.charAt(j);

                if (change && now == next) {
                    break;
                }

                if (next == now) {
                    same++;
                } else {
                    nots++;
                    change = true;
                }

                if (same == nots) {
                    res++;
                }
            }
        }

        return res;
    }

    public int countBinarySubstrings(String s) {
        int res = 0;
        int n = s.length();
        ArrayList<Integer> nums = new ArrayList<>();

        char pre = s.charAt(0);
        int num = 0;
        for (int i = 0; i < n; i++) {
            char now = s.charAt(i);
            if (now == pre) {
                num++;
            } else {
                pre = now;
                nums.add(num);
                num = 1;
            }
        }
        nums.add(num);

        for (int i = 0; i < nums.size() - 1; i++) {
            res += Math.min(nums.get(i), nums.get(i + 1));
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
//        重复出现的子串要计算它们出现的次数。
//
//        示例 1 :
//        输入: "00110011"
//        输出: 6
//        解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//        请注意，一些重复出现的子串要计算它们出现的次数。
//
//        另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
//
//        示例 2 :
//        输入: "10101"
//        输出: 4
//        解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。

        String s = "00110011";
//        String s = "10101";

        System.out.println(new T696().countBinarySubstrings(s));
        System.out.println(new T696().countBinarySubstrings_violence(s));
    }
}
