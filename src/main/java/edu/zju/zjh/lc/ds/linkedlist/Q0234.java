package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/4/8 下午 07:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode left;

    public boolean isPalindromeRecursive(ListNode head) {
        if (head == null) return true;

        boolean res = isPalindromeRecursive(head.next);
        res = (head.val == left.val) && res;
        left = left.next;

        return res;
    }

    public boolean isPalindrome0(ListNode head) {
        left = head;

        return isPalindromeRecursive(head);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, now;
        int len = 0;

        while (fast != null && fast.next != null) {
            now = slow;
            slow = slow.next;
            fast = fast.next.next;
            now.next = prev;
            prev = now;
        }

        if (fast == null) {
            // odd do nothing
        } else {
            // even
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}
