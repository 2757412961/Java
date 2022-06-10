package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 02:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0052 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p, q;

        p = headA;
        while (p != null) {
            lenA++;
            p = p.next;
        }

        q = headB;
        while (q != null) {
            lenB++;
            q = q.next;
        }

        p = headA;
        q = headB;
        if (lenA > lenB) {
            while (lenA > lenB) {
                lenA--;
                p = p.next;
            }
        } else if (lenA < lenB) {
            while (lenA < lenB) {
                lenB--;
                if (p == q) return p;
                q = q.next;
            }
        }

        while (p != null && q != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }

}
