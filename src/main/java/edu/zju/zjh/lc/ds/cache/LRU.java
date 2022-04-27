package edu.zju.zjh.lc.ds.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/27 19:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class LRU {

    class LRUCache {

        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public Node(Node prev, Node next) {
                this.prev = prev;
                this.next = next;
            }
        }

        private int capacity;
        private Node head;
        private Node tail;
        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node();
            this.tail = head;
            this.map = new HashMap<>(capacity);
        }

        public void addTail(Node node) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        public Node deleteNode(Node node) {
            if (node == null) return node;
            if (node == tail) {
                tail = node.prev;
                node.prev.next = node.next;
                node.prev = null;
                node.next = null;
            } else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                node.prev = null;
                node.next = null;
            }

            return node;
        }

        public Node deleteHead() {
            return deleteNode(head.next);
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            deleteNode(node);
            addTail(node);

            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                deleteNode(node);
            } else {
                if (map.size() == capacity) {
                    Node node = deleteHead();
                    map.remove(node.key);
                }
            }

            Node newNode = new Node(key, value);
            addTail(newNode);
            map.put(key, newNode);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRU().new LRUCache(1);

        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }

}
