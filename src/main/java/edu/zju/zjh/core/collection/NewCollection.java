package edu.zju.zjh.core.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class NewCollection {

    /**
     * Collection 接口的接口 对象的集合（单列集合）
     * ├——-List 接口：元素按进入先后有序保存，可重复
     * │—————-├ LinkedList 接口实现类， 链表， 插入删除， 没有同步， 线程不安全
     * │—————-├ ArrayList 接口实现类， 数组， 随机访问， 没有同步， 线程不安全
     * │—————-└ Vector 接口实现类 数组， 同步， 线程安全
     * │ ———————-└ Stack 是Vector类的实现类
     * └——-Set 接口： 仅接收一次，不可重复，并做内部排序，都不是线程安全
     * ├—————-└HashSet 使用hash表（数组）存储元素，都不是线程安全
     * │————————└ LinkedHashSet 链表维护元素的插入次序，都不是线程安全
     * └ —————-TreeSet 底层实现为二叉树，元素排好序，都不是线程安全
     * <p>
     * Map 接口 键值对的集合 （双列集合）
     * ├———Hashtable 接口实现类， 同步， 线程安全. Hashtable 基本被淘汰，不要在代码中使用它
     * ├———ConcurrentHashMap 接口实现类， 同步， 线程安全
     * ├———HashMap 接口实现类 ，没有同步， 线程不安全
     * │—————–├ LinkedHashMap 双向链表和哈希表实现
     * │—————–└ WeakHashMap
     * ├——–TreeMap 红黑树对所有的key进行排序
     * └———IdentifyHashMap
     * ————————————————
     * 版权声明：本文为CSDN博主「feiyanaffection」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/feiyanaffection/article/details/81394745
     */
    public static void main(String[] args) {

        /*
         * Collection List
         */
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();
        List<Integer> stack = new Stack<>();

        /*
         * Collection Queue
         */
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> linkedDeque = new LinkedList<>();
        Queue<Integer> arrayDeque = new ArrayDeque<>();

        /*
         * Collection Set
         */
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        /*
         * Map
         */
        Map<Integer, Object> hashtable = new Hashtable<>();
        Map<Integer, Object> hashMap = new HashMap<>();
        Map<Integer, Object> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Object> weakHashMap = new WeakHashMap<>();
        Map<Integer, Object> treeMap = new TreeMap<>();
        Map<Integer, Object> identityHashMap = new IdentityHashMap<>();

        // 如果需要满足线程安全，可以用 Collections 的synchronizedMap 方法使
        // HashMap 具有线程安全的能力，或者使用ConcurrentHashMap。
        Collections.synchronizedMap(hashMap);
        Map<Integer, Object> concurrentHashMap = new ConcurrentHashMap<>();

    }

}
