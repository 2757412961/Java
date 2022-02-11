package main.java.edu.zju.zjh.core.thread.pc;

/**
 * @author: zjh
 * @date : 2021/8/20 下午 04:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
