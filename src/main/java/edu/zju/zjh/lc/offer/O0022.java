package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 16:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0022 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
