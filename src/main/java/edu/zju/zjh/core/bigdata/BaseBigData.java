package edu.zju.zjh.core.bigdata;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.BitSet;

/**
 * @author: zjh
 * @date : 2022/5/24 9:32
 * @Email : 2757412961@qq.com
 * @update:
 */

public class BaseBigData {

    public static void main(String[] args) {
        /**
         * BitSet Java原生
         * 在Java中，一个int类型的整数占4字节，16比特，int的最大值也就是20多亿（具体是2147483647）。
         *
         * 假设现在有一个需求，在20亿整数中判断某个整数m是否存在，要求使用内存必须小于或者等于4GB。
         *   如果每个整数都使用int存储，那么存放20亿个整数，需要20亿 * 4byte /1024/1024/1024约等于7.45GB，显然无法满足需求。
         *   如果使用BitSet，只需要20亿 bit内存，也就是20亿/8/1024/1024/1024约等于0.233GB。
         */
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.clear(1);

        /**
         * BloomFilter 非java原生
         *
         * 	1. 垃圾邮件过滤中的黑白名单
         * 	2. 爬虫(Crawler)的网址判重模块
         *  3. 缓存穿透等问题
         */
        // 预计插入数据
        int size = 1000000;
        // 期望的误判率
        double fpp = 0.01;
        // 布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

        // 测试误判率
        int total = 1000000;
        // 插入100w样本数据
        for (int i = 0; i < total; i++) {
            bloomFilter.put(i);
        }

        // 用另外10w测试数据，测试误判率
        int count = 0;
        for (int i = total; i < total + 100000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
            }
        }
        System.out.println("总共误判数：" + count);
        System.out.println("误判率：" + (1.0 * count / 100000));

    }

}
