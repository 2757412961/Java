package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/4/6 下午 09:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0024 {

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

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head), prev = dummyHead, a, b;

        while (true){
            if (prev.next == null) break;
            if (prev.next.next == null) break;

            a = prev.next;
            b = prev.next.next;
            a.next = b.next;
            b.next = a;
            prev.next = b;

            prev = prev.next.next;
        }

        return dummyHead.next;
    }

}
