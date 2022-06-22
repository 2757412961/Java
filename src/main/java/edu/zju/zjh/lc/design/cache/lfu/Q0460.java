package edu.zju.zjh.lc.design.cache.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class Q0460 {

    /**
     * 执行耗时:73 ms,击败了31.68% 的Java用户
     * 内存消耗:131.4 MB,击败了5.07% 的Java用户
     */
    class LFUCache {

        private class Node {

            public int key;
            public int val;
            public int freq;

            public Node(int key, int val, int freq) {
                this.key = key;
                this.val = val;
                this.freq = freq;
            }

        }

        // key 到 node 的映射
        private Map<Integer, Node> key2node;
        // freq 到 key 列表的映射
        private Map<Integer, LinkedHashSet<Integer>> freq2key;
        // 记录 LFU 缓存的最大容量
        int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.key2node = new HashMap<>();
            this.freq2key = new TreeMap<>();
        }

        public void addFreqKey(Node node) {
            if (!freq2key.containsKey(node.freq)) freq2key.put(node.freq, new LinkedHashSet<>());
            LinkedHashSet<Integer> keys = freq2key.get(node.freq);
            keys.add(node.key);
        }

        public void deleteFreqKey(Node node) {
            LinkedHashSet<Integer> keys = freq2key.get(node.freq);
            keys.remove(node.key);
            if (keys.size() == 0) freq2key.remove(node.freq);
        }

        public Node getMinFreqNode() {
            Integer minFreq = freq2key.keySet().iterator().next();
            LinkedHashSet<Integer> keys = freq2key.get(minFreq);
            Integer minFreqKey = keys.iterator().next();

            return key2node.get(minFreqKey);
        }

        public Node increaseKeyFreq(int key) {
            Node node = key2node.get(key);
            deleteFreqKey(node);
            node.freq++;
            addFreqKey(node);

            return node;
        }

        public int get(int key) {
            if (!key2node.containsKey(key)) return -1;

            Node node = increaseKeyFreq(key);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity <= 0) return;

            if (key2node.containsKey(key)) {
                Node node = increaseKeyFreq(key);
                node.val = value;
                return;
            }

            if (key2node.size() == capacity) {
                Node minFreqNode = getMinFreqNode();
                key2node.remove(minFreqNode.key);
                deleteFreqKey(minFreqNode);
            }
            Node node = new Node(key, value, 1);
            key2node.put(key, node);
            addFreqKey(node);
        }

        public void print() {
            key2node.keySet().forEach(System.out::print);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        LFUCache lfu = new Q0460().new LFUCache(2);
        lfu.put(1, 1); // cache=[1,_], cnt(1)=1
        lfu.print();
        lfu.put(2, 2); // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.print();
        lfu.get(1);    // 返回 1 cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3); // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小 cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.print();
        lfu.get(2);    // 返回 -1（未找到）
        lfu.get(3);    // 返回 3 cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4); // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用 cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.print();
        lfu.get(1);    // 返回 -1（未找到）
        lfu.get(3);    // 返回 3 cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);    // 返回 4 cache=[3,4], cnt(4)=2, cnt(3)=3
    }

}
