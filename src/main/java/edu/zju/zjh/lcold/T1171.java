package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;

public class T1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode res = new ListNode(-1);
        HashMap<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        res.next = head;
        map.put(sum, res);

        while (head != null) {
            sum += head.val;
            if (!map.containsKey(sum)) {
                map.put(sum, head);
            } else {
                ListNode node = map.get(sum);
                ListNode root = map.get(sum);

                int tempSum = sum;
                if (root == head){
                    map.remove(tempSum);
                } else {
                    root = root.next;
                    while (root != head) {
                        tempSum += root.val;
                        map.remove(tempSum);

                        root = root.next;
                    }
                }

                map.put(0, res);
                node.next = head.next;
            }

            head = head.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];
        nodes[0] = new ListNode(1);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(-2);
        nodes[3] = new ListNode(2);
        nodes[4] = new ListNode(-2);

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        new T1171().removeZeroSumSublists(nodes[0]);
    }
}
