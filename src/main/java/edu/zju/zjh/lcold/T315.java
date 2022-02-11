package main.java.edu.zju.zjh.lcold;

import java.util.*;

public class T315 {
    public List<Integer> countSmaller_violence(int[] nums) {
        int n = nums.length;
        Integer[] res = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
            res[i] = count;
        }

        return Arrays.asList(res);
    }


    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};

        System.out.println(new T315().countSmaller(nums));
        System.out.println(new T315().countSmaller_violence(nums));
    }
}
