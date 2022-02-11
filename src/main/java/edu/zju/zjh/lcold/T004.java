package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T004 {
    public double findMedianSortedArrays_VIOLENCE(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        double res = n > 0 ? nums1[0] : nums2[0];

        int l1 = 0, l2 = 0;
        ArrayList<Integer> merge = new ArrayList<>();

        while (l1 < n && l2 < m) {
            if (nums1[l1] < nums2[l2]) {
                merge.add(nums1[l1++]);
            } else {
                merge.add(nums2[l2++]);
            }
        }

        while (l1 < n) {
            merge.add(nums1[l1++]);
        }

        while (l2 < m) {
            merge.add(nums2[l2++]);
        }

        int mid = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            res = merge.get(mid);
        } else {
            res = ((double) (merge.get(mid) + merge.get(mid - 1))) / 2;
        }

        return res;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4};
        int[] nums2 = new int[]{2, 3, 6};

        System.out.println(new T004().findMedianSortedArrays(nums1, nums2));
        System.out.println(new T004().findMedianSortedArrays_VIOLENCE(nums1, nums2));
    }
}
