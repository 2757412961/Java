package edu.zju.zjh.offer;

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

    /**
     * 方法二：迭代 + 节点拆分
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了45.00% 的Java用户
     */
    private class S1 {

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

    /**
     * 方法一：回溯 + 哈希表
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了15.31% 的Java用户
     */
    private class S2 {

        private Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (map.containsKey(head)) return map.get(head);

            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);

            return node;
        }

    }

}
