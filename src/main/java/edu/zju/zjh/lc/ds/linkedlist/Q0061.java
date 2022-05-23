package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/5/23 19:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0061 {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 0, dis;
        ListNode dummy = new ListNode(-1), p = head, slow = head, fast = head;

        while (p != null) {
            p = p.next;
            len++;
        }

        dis = k % len;
        while (dis > 1) {
            fast = fast.next;
            dis--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        p = slow.next;
        dummy.next = slow.next;
        slow.next = null;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;

        return dummy.next;
    }

}
