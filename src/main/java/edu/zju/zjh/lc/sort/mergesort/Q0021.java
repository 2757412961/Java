package edu.zju.zjh.lc.sort.mergesort;

/**
 * @author: zjh
 * @date : 2022/2/20 22:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0021 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode pointer = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        while (list1 != null) {
            pointer.next = list1;
            list1 = list1.next;
            pointer = pointer.next;
        }

        while (list2 != null) {
            pointer.next = list2;
            list2 = list2.next;
            pointer = pointer.next;
        }

        return head.next;
    }

}
