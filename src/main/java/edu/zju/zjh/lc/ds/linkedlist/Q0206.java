package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/2/28 20:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0206 {

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

    public ListNode reverseList1(ListNode head) {
        ListNode now = null, last = null;

        while (head != null) {
            now = head;
            head = head.next;
            now.next = last;
            last = now;
        }

        return last;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return ret;
    }

}
