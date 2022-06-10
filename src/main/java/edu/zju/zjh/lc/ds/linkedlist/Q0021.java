package edu.zju.zjh.lc.ds.linkedlist;

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

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了67.01% 的Java用户
     */
    private class S2 {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(), cur = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            while (list1 != null) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }

            while (list2 != null) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }

            return dummy.next;
        }

    }

}
