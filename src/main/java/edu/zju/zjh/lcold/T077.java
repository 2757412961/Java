package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/8 上午 12:18
 * @Modified_By :
 */
public class T077 {
    List<List<Integer>> res = new ArrayList<>();

    public void huisu(int n, int k, int pos, List<Integer> nums) {
        if (nums.size() >= k) {
            res.add(new ArrayList<>(nums));

            return;
        }

        for (int i = pos; i < n; i++) {
            nums.add(i + 1);
            huisu(n, k, i + 1, nums);
            nums.remove(nums.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        huisu(n, k, 0, new ArrayList<>());

        return res;
    }

    public static void main(String[] args) {
//        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//        输入: n = 4, k = 2
//        输出:
//        [
//          [2,4],
//          [3,4],
//          [2,3],
//          [1,2],
//          [1,3],
//          [1,4],
//        ]

        int n = 4, k = 2;

        System.out.println(new T077().combine(n, k));
    }
}
