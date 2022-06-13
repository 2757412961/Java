package edu.zju.zjh.lc.ds.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/31 15:28
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0143 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：线性表 因为链表不支持下标访问，所以我们无法随机访问链表中任意位置的元素。
     * 执行耗时:3 ms,击败了34.75% 的Java用户
     * 内存消耗:43.8 MB,击败了71.64% 的Java用户
     */
    private class S1 {

        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode cur = head, dummy = new ListNode(-1);

            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }

            int i = 0, j = list.size() - 1;
            boolean isOrder = true;
            while (i <= j) {
                if (isOrder) {
                    dummy.next = list.get(i++);
                } else {
                    dummy.next = list.get(j--);
                }
                isOrder = !isOrder;
                dummy = dummy.next;
                dummy.next = null;
            }
        }

    }

    /**
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     * 执行耗时:2 ms,击败了42.68% 的Java用户
     * 内存消耗:43.8 MB,击败了78.65% 的Java用户
     */
    private class S2 {

        public void reorderList(ListNode head) {
            int n = 0, idx = 0;
            ListNode p = head, q = head, dummy = new ListNode(-1), cur = dummy;
            LinkedList<ListNode> stack = new LinkedList<>();

            // 计算长度
            while (q != null) {
                q = q.next;
                n++;
            }

            // 找到中点的前一个节点
            q = head;
            if (n % 2 == 0) idx++;
            while (idx < n / 2) {
                q = q.next;
                idx++;
            }

            // 入栈
            ListNode last = q;
            q = q.next;
            last.next = null;
            while (q != null) {
                stack.offerLast(q);
                q = q.next;
            }

            // 组合
            while (p != null) {
                if (p != null) {
                    cur.next = p;
                    cur = cur.next;
                    p = p.next;
                }
                if (!stack.isEmpty()) {
                    cur.next = stack.pollLast();
                    cur = cur.next;
                }
                cur.next = null;
            }
        }

    }

}
