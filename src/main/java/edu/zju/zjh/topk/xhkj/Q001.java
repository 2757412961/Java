package edu.zju.zjh.topk.xhkj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/7/15 16:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            long res = 0;
            Map<Integer, Long> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int key = nums[i] - i;
                map.put(key, map.getOrDefault(key, 0L) + 1);
            }

            for (Map.Entry<Integer, Long> e : map.entrySet()) {
                Long value = e.getValue();
                res += value * (value - 1) / 2;
            }

            System.out.println(res);
        }
    }

}
