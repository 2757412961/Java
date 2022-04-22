package edu.zju.zjh.core.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author: zjh
 * @date : 2022/4/22 19:35
 * @Email : 2757412961@qq.com
 * @update:
 */

/**
 * Executors.newFixedThreadPool(): new LinkedBlockingQueue<Runnable>()
 * Executors.newSingleThreadExecutor(): new LinkedBlockingQueue()
 * 以上两种创建的方式不推荐，因为使用了linkedBlockingQueue的无界队列，会导致最大线程数以及多余核心的keepalive的参数失效。 而因为无初始值的new LinkedBlockingQueue()是无界队列的关系，当任务过多会导致OOM
 *
 * Executors.newCachedThreadPool(): new SynchronousQueue<Runnable>()
 * 不推荐用newCacheThreadPool的原因是因为最大线程数设置为Integer.MAX_VALUE,如果主线程提交任务的速度高于 maximumPool 中线程处理任务的速度时，会耗尽CUP及内存。
 *
 * Executors.newScheduledThreadPool(): new DelayedWorkQueue() 中封装了一个 PriorityQueue
 * 任务队列 DelayedWorkQueue 封装了一个 PriorityQueue，PriorityQueue 会对队列中的任务进行排序，执行所需时间短的放在前面先被执行(ScheduledFutureTask 的 time 变量小的先执行)，如果执行所需时间相同则先提交的任务将被先执行(ScheduledFutureTask 的 squenceNumber 变量小的先执行)。
 * 队列原理与 DelayQueue 基本一致
 *
 * Executors.newWorkStealingPool(): 内部会构建ForkJoinPool，利用Work-Stealing算法，并行地处理任务，不保证处理顺序。
 * 工作窃取算法: 工作窃取(work-stealing)算法是指某个线程从其他队列里窃取任务来执行。一个大任务分割为若干个互不依赖的子任务，为了减少线程间的竞争，把这些子任务分别放到不同的队列里，并未每个队列创建一个单独的线程来执行队列里的任务，线程和队列一一对应。比如线程1负责处理1队列里的任务，2线程负责2队列的。但是有的线程会先把自己队列里的任务干完，而其他线程对应的队列里还有任务待处理。干完活的线程与其等着，不如帮其他线程干活，于是它就去其他线程的队列里窃取一个任务来执行。默认从其他队列的队尾开始窃取任务执行。
 * 思想为: 充分利用线程进行并行计算，减少线程间的竞争。在某些情况下还是会存在竞争，比如双端队列里只有一个任务时。并且该算法会消耗更多的系统资源， 比如创建多个线程和多个双端队列。
 */
public class ExecutorsAll {

    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // 最大线程数设置为Integer.MAX_VALUE

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        ExecutorService workStealingPool = Executors.newWorkStealingPool();

    }

}
