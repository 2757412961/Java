package edu.zju.zjh.lcold;

import java.util.ArrayList;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/5 上午 12:28
 * @Modified_By :
 */
public class T060 {
    public String getPermutation(int n, int k) {
        int base = 1, div, rem = k, ite = n - 1;
        ArrayList<Integer> nums = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < n; i++) {
            base *= i;
            nums.add(i);
        }
        nums.add(n);

        while (ite > 0) {
            div = rem / base;
            rem = rem - div * base;
            if (rem == 0) {
                div--;
                rem += base;
            }

            sb.append(nums.get(div));
            nums.remove(div);

            base /= ite;
            ite--;
        }
        sb.append(nums.get(0));

        return sb.toString();
    }

    public static void main(String[] args) {
//        给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
//        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        给定 n 和 k，返回第 k 个排列。
//
//        说明：
//        给定 n 的范围是 [1, 9]。
//        给定 k 的范围是[1,  n!]。

//        示例 1:
//        输入: n = 3, k = 3
//        输出: "213"

//        示例 2:
//        输入: n = 4, k = 9
//        输出: "2314"

        int n = 4;
        int k = 9;

        System.out.println(new T060().getPermutation(n, k));
    }
}
