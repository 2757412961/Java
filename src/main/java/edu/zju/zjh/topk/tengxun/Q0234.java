package edu.zju.zjh.topk.tengxun;

/**
 * @author: zjh
 * @date : 2022/5/16 10:46
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

    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode slow = head, fast = head, cur = head, prev = null;

        while (cur != null) {
            cur = cur.next;
            size++;
        }

        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;

            cur.next = prev;
            prev = cur;
        }

        if (size % 2 == 1) {
            slow = slow.next;
        }

        while (slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}
