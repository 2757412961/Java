package edu.zju.zjh.lc.ds.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: zjh
 * @date : 2022/6/14 17:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 执行耗时:2 ms,击败了70.51% 的Java用户
     * 内存消耗:41.6 MB,击败了21.74% 的Java用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        LinkedList<ListNode> s1 = new LinkedList<>();
        LinkedList<ListNode> s2 = new LinkedList<>();
        int carry = 0;

        while (l1 != null) {
            s1.offerLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.offerLast(l2);
            l2 = l2.next;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode node1 = s1.pollLast();
            ListNode node2 = s2.pollLast();

            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        while (!s1.isEmpty()) {
            ListNode node1 = s1.pollLast();

            int sum = node1.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        while (!s2.isEmpty()) {
            ListNode node2 = s2.pollLast();

            int sum = node2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }

}
