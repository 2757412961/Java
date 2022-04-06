package edu.zju.zjh.lc.ds.linkedlist;

import java.util.List;

/**
 * @author: zjh
 * @date : 2022/4/6 下午 08:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0019 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), prev = dummy;

        while (n-- > 0) {
            head = head.next;
        }

        while (head != null) {
            prev = prev.next;
            head = head.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }

}
