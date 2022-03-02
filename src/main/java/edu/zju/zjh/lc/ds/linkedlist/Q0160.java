package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/1 16:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0160 {

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode slow = headB;
        ListNode fast = headB;
        while (p.next != null) {
            p = p.next;
        }
        p.next = headA;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            p.next = null;
            return null;
        }

        slow = headB;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        p.next = null;

        return slow;
    }

}
