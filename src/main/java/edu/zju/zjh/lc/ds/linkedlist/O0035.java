package edu.zju.zjh.lc.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class O0035 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(0), p, q, node;
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);

        q = head;
        p = dummyHead;
        while (q != null) {
            if (map.containsKey(q)) {
                node = map.get(q);
            } else {
                node = new Node(q.val);
                map.put(q, node);
            }
            p.next = node;

            q = q.next;
            p = p.next;
        }

        q = head;
        p = dummyHead.next;
        while (q != null) {
            node = map.get(q.random);
            p.random = node;

            q = q.next;
            p = p.next;
        }

        return dummyHead.next;
    }

}
