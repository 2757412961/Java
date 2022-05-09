package edu.zju.zjh.lc.array.nsum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0015 {

    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> ins = new ArrayList<>();
                        ins.add(nums[i]);
                        ins.add(nums[j]);
                        ins.add(nums[k]);
                        res.add(ins);
                    }
                    break;
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ArrayList<Integer> ins = new ArrayList<>();
                    ins.add(nums[i]);
                    ins.add(nums[l]);
                    ins.add(nums[r]);
                    res.add(ins);

                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int i, int j) {
        if (i >= j) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                do { j--; } while (i < j && nums[j] == nums[j + 1]);
            } else if (sum < target) {
                do { i++; } while (i < j && nums[i] == nums[i - 1]);
            } else if (sum == target) {
                int finalI = i;
                int finalJ = j;
                res.add(new LinkedList<Integer>() {{
                    add(nums[finalI]);
                    add(nums[finalJ]);
                }});
                do { i++; } while (i < j && nums[i] == nums[i - 1]);
                do { j--; } while (i < j && nums[j] == nums[j + 1]);
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> lists = twoSum(nums, -nums[i], i + 1, n - 1);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                res.add(list);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{1, 0, 1, 2, -1, -4, -1};
        int[] nums3 = new int[]{0, 0, 0, 0};

        System.out.println("====================================");
        new Q0015().threeSum01(nums1).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum01(nums2).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum01(nums3).forEach(System.out::println);
        System.out.println();

        System.out.println("====================================");
        new Q0015().threeSum02(nums1).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum02(nums2).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum02(nums3).forEach(System.out::println);
        System.out.println();

        System.out.println("====================================");
        new Q0015().threeSum(nums1).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum(nums2).forEach(System.out::println);
        System.out.println();
        new Q0015().threeSum(nums3).forEach(System.out::println);
        System.out.println();
    }

}
