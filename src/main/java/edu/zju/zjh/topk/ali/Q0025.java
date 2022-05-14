package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/14 13:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0025 {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, cur = head, first, last = head;
        int step = 1;

        while (last != null) {
            step = 1;
            while (step <= k && last != null) {
                step++;
                last = last.next;
            }
            if (last == null && step <= k) break;

            step = 1;
            first = cur;
            while (step <= k && cur != null) {
                ListNode temp = cur;
                cur = cur.next;

                temp.next = prev.next;
                prev.next = temp;

                step++;
            }
            first.next = cur;
            prev = first;
        }

        return dummy.next;
    }

}
