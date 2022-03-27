package edu.zju.zjh.lc.cache;

import lombok.val;

import java.util.*;

public class Q0146 {

    class LRUCache0 {

        private int capacity;
        private Map<Integer, Integer> map = new LinkedHashMap<>();

        public LRUCache0(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() >= capacity) {
                    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
                    Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
                    if (iterator.hasNext()) {
                        Map.Entry<Integer, Integer> next = iterator.next();
                        map.remove(next.getKey());
                    }
                }
                map.put(key, value);
            } else {
                map.remove(key);
                map.put(key, value);
            }
        }
    }

    static class LRUCache {

        class DoubleNode<T> {
            public T key;
            public T val;
            public DoubleNode<T> prev;
            public DoubleNode<T> next;

            public DoubleNode() {

            }

            public DoubleNode(T key, T val) {
                this.key = key;
                this.val = val;
            }

            public DoubleNode(DoubleNode<T> prev, DoubleNode<T> next) {
                this.prev = prev;
                this.next = next;
            }
        }

        class DoubleNodeList<T> {
            public DoubleNode<T> head;
            public int size;

            public DoubleNodeList() {
                head = new DoubleNode<>();
                head.next = head;
                head.prev = head;
            }

            public void addLast(DoubleNode<T> element) {
                size++;
                element.next = head;
                element.prev = head.prev;
                head.prev.next = element;
                head.prev = element;
            }

            public void remove(DoubleNode<T> element) {
                if (size == 0) return;
                size--;
                element.prev.next = element.next;
                element.next.prev = element.prev;
                element.prev = null;
                element.next = null;
            }

            public void removeFirst() {
                remove(head.next);
            }

            public DoubleNode getFirst() {
                if (size == 0) return null;
                return head.next;
            }
        }

        private int capacity;
        private DoubleNodeList<Integer> list;
        private Map<Integer, DoubleNode<Integer>> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            list = new DoubleNodeList<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            DoubleNode<Integer> node = map.get(key);
            list.remove(node);
            DoubleNode<Integer> newNode = new DoubleNode<>(node.key, node.val);
            list.addLast(newNode);
            map.put(key, newNode);

            return node.val;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == capacity) {
                    map.remove(list.getFirst().key);
                    list.removeFirst();
                }
            } else {
                list.remove(map.get(key));
            }
            DoubleNode<Integer> newNode = new DoubleNode<>(key, value);
            list.addLast(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }

}
