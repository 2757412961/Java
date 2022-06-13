package edu.zju.zjh.lc.ds.linkedlist;

/**
 * @author: zjh
 * @date : 2022/3/1 16:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0160 {

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
     * 连接两个链表，转换成链表找环的问题
     */
    private class S1 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode slow = headB;
            ListNode fast = headB;
            while (p.next != null) {
                p = p.next;
            }
            p.next = headA;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }

            if (fast == null || fast.next == null) {
                p.next = null;
                return null;
            }

            slow = headB;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            p.next = null;

            return slow;
        }

    }

    /**
     * 计算链表长度，然后对齐
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.7 MB,击败了5.12% 的Java用户
     */
    private class S2 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int m = 0, n = 0;
            ListNode p, q;

            // 计算链表长度
            p = headA;
            while (p != null) {
                p = p.next;
                m++;
            }
            q = headB;
            while (q != null) {
                q = q.next;
                n++;
            }

            // 如果B必A长，则交换
            if (m >= n) {
                p = headA;
                q = headB;
            } else {
                p = headB;
                q = headA;
                m = m + n;
                n = m - n;
                m = m - n;
            }

            // 对齐长度
            while (m > n) {
                m--;
                p = p.next;
            }

            // 对齐长度后，寻找第一个相同的节点
            while (p != null && q != null) {
                if (p == q) return p;
                p = p.next;
                q = q.next;
            }

            // 否则返回null
            return null;
        }

    }

}
