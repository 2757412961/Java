package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/11 10:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
