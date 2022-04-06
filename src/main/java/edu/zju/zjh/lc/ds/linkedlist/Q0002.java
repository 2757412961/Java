package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/4/6 下午 08:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0002 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode dummyHead = new ListNode(), head = dummyHead;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}
