package edu.zju.lemon.company.wangyi;

import java.util.ArrayList;
import java.util.List;

public class Q002 {

    public List<List<Long>> twoSum(long l, long r, long target) {
        List<List<Long>> res = new ArrayList<>();

        while (l < r) {
            long sum = l + r;
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else if (sum == target) {
                List<Long> one = new ArrayList<>();
                one.add(l);
                one.add(r);
                res.add(one);
                l++;
                r--;
            }
        }

        return res;
    }

    public List<List<Long>> nSum(long l, long r, long target, long level) {
        List<List<Long>> res = new ArrayList<>();
        if (level < 2) return res;

        if (level == 2) {
            List<List<Long>> twoSumList = twoSum(l, r, target);
            res = twoSumList;
        } else if (level > 2) {
            for (long i = l; i <= r; i++) {
                res = nSum(i + 1, r, target - i, level - 1);
                long addVal = i;
                for (int li = 0; li < res.size(); li++) {
                    List<Long> list = res.get(li);
                    list.add(addVal);
                    res.add(list);
                }
                if (res.size() > 0) break;
            }
        }

        return res;
    }

    public List<List<Long>> nSum(long n, long k, long x) {
        return nSum(1, k, x, n);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
//        long k = in.nextLong();
//        long x = in.nextLong();
        long n = 9;
        long k = 48684248;
        long x = 148644865;
        // 1 3 5 6

        List<List<Long>> lists = new Q002().nSum(n, k, x);
        if (lists.size() == 0) {
            System.out.println("-1");
        } else {
            for (Long num : lists.get(0)) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
