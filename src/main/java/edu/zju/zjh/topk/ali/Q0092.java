package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/14 13:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0092 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, cur = head, first;

        int step = 1;
        while (step < left && cur != null) {
            step++;
            prev = prev.next;
            cur = cur.next;
        }
        first = cur;

        while (step <= right && cur != null) {
            ListNode temp = cur;
            cur = cur.next;

            temp.next = prev.next;
            prev.next = temp;

            step++;
        }
        first.next = cur;

        return dummy.next;
    }

}
