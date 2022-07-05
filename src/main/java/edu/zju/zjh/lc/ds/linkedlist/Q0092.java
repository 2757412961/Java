package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/1 21:20
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

    /**
     *
     */
    private class S1 {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (right - left <= 0) return head;

            int i = 0;
            ListNode dummyHead = new ListNode(0, head), start = dummyHead, end;
            while (++i < left) {
                start = start.next;
            }
            end = start.next;
            while (++i <= right) {
                end = end.next;
            }
            end = end.next;

            ListNode newStart = start.next;
            ListNode prev = end, now = start.next;
            ListNode p = start.next;
            while (p != end) {
                now = p;
                p = p.next;
                now.next = prev;
                prev = now;
            }
            start.next = now;

            return dummyHead.next;
        }

    }

    /**
     *
     */
    private class S2 {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (right - left <= 0) return head;
            ListNode dummyHead = new ListNode(0, head);
            ListNode prev = dummyHead;
            int i = 0;
            while (++i < left) {
                prev = prev.next;
            }
            ListNode now = prev.next, after;

            i--;
            while (++i <= right) {
                after = now.next;
                now.next = after.next;
                after.next = now;
                prev.next = after;
            }

            return dummyHead.next;
        }

    }

}
