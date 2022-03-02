package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/2 11:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0328 {

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

    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(), evenLast = evenHead;
        ListNode oddHead = new ListNode(), oddLast = oddHead;
        ListNode now;
        boolean isEven = true;

        while (head != null) {
            now = head;
            head = head.next;
            now.next = null;
            if (isEven) {
                evenLast.next = now;
                evenLast = evenLast.next;
            } else {
                oddLast.next = now;
                oddLast = oddLast.next;
            }

            isEven = !isEven;
        }
        evenLast.next = oddHead.next;

        return evenHead.next;
    }

}
