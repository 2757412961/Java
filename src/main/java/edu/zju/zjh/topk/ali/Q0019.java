package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/10 9:56
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
        if (head == null || n <= 0) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = head;

        while (n > 0 && fast != null) {
            n--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

}
