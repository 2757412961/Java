package edu.zju.zjh.lc.ds.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q0496 {

    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            Integer idx = map.get(nums1[i]);
            int j = idx + 1;
            for (; j < nums2.length; j++) {
                if (nums2[idx] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                nums1[i] = -1;
            }
        }

        return nums1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                Integer peek = stack.peek();
                stack.push(nums2[i]);
                nums2[i] = peek;
            } else {
                stack.push(nums2[i]);
                nums2[i] = -1;
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums2[map.get(nums1[i])];
        }

        return nums1;
    }

}
