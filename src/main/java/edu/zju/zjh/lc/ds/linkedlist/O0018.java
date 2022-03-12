package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/12 16:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0018 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(), p = dummy;
        dummy.next = head;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }

        return dummy.next;
    }

}
