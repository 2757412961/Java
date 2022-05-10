package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/10 9:46
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

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = dummy, c;

        while (head != null) {
            c = head;
            head = head.next;

            c.next = p.next;
            p.next = c;
        }

        return dummy.next;
    }

}
