package edu.zju.zjh.lcold;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class T021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode res = root;

        while (l1 != null || l2 != null) {
            if (l1 == null){
                root.next = l2;
                l2 = l2.next;
                root = root.next;
            } else if(l2 == null){
                root.next = l1;
                l1 = l1.next;
                root = root.next;
            }else {
                if (l1.val < l2.val){
                    root.next = l1;
                    l1 = l1.next;
                    root = root.next;
                } else {
                    root.next = l2;
                    l2 = l2.next;
                    root = root.next;
                }
            }
        }

        return res.next;
    }

    public static void main(String[] args) {

    }
}
