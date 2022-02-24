package edu.zju.zjh.lc.sort.mergesort;

/**
 * @author: zjh
 * @date : 2022/2/20 21:50
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0148 {

    public static class ListNode {
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

    public ListNode findMidList(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
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

    /**
     * 分治算法
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode temp = findMidList(head);
        ListNode mid = temp.next;
        temp.next = null;

        ListNode left = sortList(head);
        ListNode righ = sortList(mid);

        return mergeTwoLists(left, righ);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = new Q0148().sortList(listNode1);
        System.out.println();
    }

}
