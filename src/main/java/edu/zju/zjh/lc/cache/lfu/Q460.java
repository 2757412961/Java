package edu.zju.zjh.lc.cache.lfu;

import java.util.LinkedHashSet;
import java.util.Map;

public class Q460 {

    class LFUCache {

        private Map<Integer, Integer> key2val;
        private Map<Integer, Integer> key2freq;
        private Map<Integer, LinkedHashSet<Integer>> freq2keys;

        public LFUCache(int capacity) {

        }

        public int get(int key) {



            return -1;
        }

        public void put(int key, int value) {

        }
    }

}
