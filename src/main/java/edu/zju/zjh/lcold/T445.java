package main.java.edu.zju.zjh.lcold;

import java.util.Stack;

public class T445 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void add2Stack(ListNode nodes, Stack<ListNode> s) {
        while (nodes != null) {
            s.push(nodes);
            nodes = nodes.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int jinwei = 0;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> s = new Stack<>();

        add2Stack(l1, s1);
        add2Stack(l2, s2);

        while (!s1.empty() && !s2.empty()) {
            ListNode node1 = s1.pop();
            ListNode node2 = s2.pop();
            ListNode node = new ListNode((node1.val + node2.val + jinwei) % 10);
            jinwei = (node1.val + node2.val + jinwei) / 10;
            s.push(node);
        }

        while (!s1.empty()) {
            ListNode node1 = s1.pop();
            ListNode node = new ListNode((node1.val + jinwei) % 10);
            jinwei = (node1.val + jinwei) / 10;
            s.push(node);
        }

        while (!s2.empty()) {
            ListNode node2 = s2.pop();
            ListNode node = new ListNode((node2.val + jinwei) % 10);
            jinwei = (node2.val + jinwei) / 10;
            s.push(node);
        }

        if (jinwei > 0){
            ListNode node = new ListNode((jinwei) % 10);
            s.push(node);
        }

        ListNode node0 = s.pop();
        head = node0;
        while (!s.empty()){
            ListNode node = s.pop();
            head.next = node;
            head = node;
        }

        return node0;
    }


    public void linklist(ListNode[] lst) {
        for (int i = 0; i < lst.length - 1; i++) {
            lst[i].next = lst[i + 1];
        }
    }

    public static void main(String[] args) {
        ListNode[] lst1 = new ListNode[]{
                new ListNode(7),
                new ListNode(2),
                new ListNode(4),
                new ListNode(3),
        };
        ListNode[] lst2 = new ListNode[]{
                new ListNode(5),
                new ListNode(6),
                new ListNode(4),
        };

        T445 t445 = new T445();
        t445.linklist(lst1);
        t445.linklist(lst2);
        t445.addTwoNumbers(lst1[0], lst2[0]);
    }
}
