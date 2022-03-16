package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/16 15:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0024 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode now;

        while (head != null) {
            now = head;
            head = head.next;

            now.next = dummy.next;
            dummy.next = now;
        }

        return dummy.next;
    }

}
