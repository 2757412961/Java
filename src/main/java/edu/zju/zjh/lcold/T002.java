package main.java.edu.zju.zjh.lcold;

public class T002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode res = root;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            carry = num / 10;
            root.next = new ListNode(num % 10);

            root = root.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int num = l1.val + carry;
            carry = num / 10;
            root.next = new ListNode(num % 10);

            root = root.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int num = l2.val + carry;
            carry = num / 10;
            root.next = new ListNode(num % 10);

            root = root.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            root.next = new ListNode(carry);
        }

        return res.next;
    }

    public static void main(String[] args) {
//        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
//        并且它们的每个节点只能存储 一位 数字。
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = new T002().addTwoNumbers(l1, l2);
        System.out.println();
    }
}
