package edu.zju.zjh.lc.array;

import java.util.PriorityQueue;

public class Q0414 {

    public int thirdMax0(int[] nums) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!pr.contains(nums[i])) {
                pr.offer(nums[i]);
            }
            if (pr.size() > 3) {
                pr.poll();
            }
        }

        if (pr.size() == 3) return pr.peek();
        while (pr.size() > 0) {
            res = pr.poll();
        }

        return res;
    }

    public int thirdMax1(int[] nums) {
        int first = 0, second = 0, third = 0;
        boolean visf = false, viss = false, vist = false;

        for (int i = 0; i < nums.length; i++) {
            if (!visf || nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
                if (viss) {
                    vist = true;
                }
                if (visf) {
                    viss = true;
                }
                visf = true;
            } else if (nums[i] < first && (!viss || nums[i] > second)) {
                third = second;
                second = nums[i];
                if (viss) {
                    vist = true;
                }
                viss = true;
            } else if (nums[i] < first && nums[i] < second && (!vist || nums[i] > third)) {
                third = nums[i];
                vist = true;
            }
        }

        if (vist) return third;
        return first;
    }

    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        System.out.println(new Q0414().thirdMax0(new int[]{3, 2, 1, 3}));
        System.out.println(new Q0414().thirdMax(new int[]{3, 2, 1, 3}));
        System.out.println(new Q0414().thirdMax0(new int[]{1, 2}));
        System.out.println(new Q0414().thirdMax(new int[]{1, 2}));
        System.out.println(new Q0414().thirdMax0(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
        System.out.println(new Q0414().thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
    }

}
