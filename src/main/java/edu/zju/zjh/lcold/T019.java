package main.java.edu.zju.zjh.lcold;

public class T019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        ListNode pre = p1;

        while (n > 0 && p2 != null) {
            p2 = p2.next;
            n--;
        }

        while (p2 != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (head == p1) {
            head = head.next;
        } else {
            pre.next = pre.next != null ? pre.next.next : null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[1];
        int n = 1;

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i + 1);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        new T019().removeNthFromEnd(nodes[0], n);
    }

}
