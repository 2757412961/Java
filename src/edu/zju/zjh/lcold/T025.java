package edu.zju.zjh.lcold;

import java.util.Stack;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}


public class T025 {
    public ListNode reverseKGroup_violence(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        ListNode poter = res;
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            stack.push(node);
            if (stack.size() == k) {
                while (stack.size() > 0) {
                    poter.next = stack.pop();
                    poter = poter.next;
                }
            }
        }

        Stack<ListNode> reverse = new Stack<>();
        while (stack.size() > 0) {
            reverse.push(stack.pop());
        }
        while (reverse.size() > 0) {
            poter.next = reverse.pop();
            poter = poter.next;
        }

        return res.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        ListNode node = res;
        ListNode sta = head, now = null, end = null, pre = null, next = null;
        int count = 0;

        while (head != null) {
            end = head;
            head = head.next;
            count++;

            if (count == k) {
                count = 0;
                now = sta;
                pre = null;
                while (now != head) {
                    next = now.next;
                    now.next = pre;
                    pre = now;
                    now = next;
                }

                node.next = pre;
                node = sta;
                sta.next = head;

                sta = head;
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[8];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        ListNode head = nodes[0];
        int k = 3;

        new T025().reverseKGroup(head, k);
        new T025().reverseKGroup_violence(head, k);
    }
}
