package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/5/16 13:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0203 {

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur .next;
        }

        return dummy.next;
    }

}
