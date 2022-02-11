package main.java.edu.zju.zjh.lcold;

public class T147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode root, oldhead, pre;

        int n = 0;
        while (head != null) {
            n++;

            root = res;
            pre = res;
            oldhead = head;
            head = head.next;
            oldhead.next = null;


            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (flag == 1 && root.val > oldhead.val) {
                    pre.next = oldhead;
                    oldhead.next = root;

                    flag = 0;
                }

                pre = root;
                root = root.next;
            }

            if (flag == 1){
                pre.next = oldhead;
            }
        }


        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i);
        }

        nodes[4].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[0];
        nodes[0].next = nodes[1];

        new T147().insertionSortList(nodes[4]);
    }

}
