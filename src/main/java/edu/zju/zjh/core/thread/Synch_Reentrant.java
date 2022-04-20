package edu.zju.zjh.core.thread;

/**
 * @author: zjh
 * @date : 2022/4/20 14:18
 * @Email : 2757412961@qq.com
 * @update:
 */

/**
 * synchronized是基于原子性的内部锁机制，是可重入的，因此在一个线程调用synchronized方法的同时
 * 在其方法体内部调用该对象另一个synchronized方法，也就是说一个线程得到一个对象锁后再次请求该对象锁，是允许的.
 * 这就是synchronized的可重入性。
 *
 * synchronized可重入锁的实现原理：
 *   synchronized底层是利用计算机系统mutex Lock实现的。每一个可重入锁都会关联一个线程ID和一个锁状态status。
 *   当一个线程请求方法时，会去检查锁状态。
     * 如果锁状态是0，代表该锁没有被占用，使用CAS操作获取锁，将线程ID替换成自己的线程ID。
     * 如果锁状态不是0，代表有线程在访问该方法。此时，如果线程ID是自己的线程ID，如果是可重入锁，会将status自增1，然后获取到该锁，进而执行相应的方法；如果是非重入锁，就会进入阻塞队列等待。
 *   在释放锁时，
     * 如果是可重入锁的，每一次退出方法，就会将status减1，直至status的值为0，最后释放该锁。
     * 如果非可重入锁的，线程退出方法，直接就会释放该锁。
 */
public class Synch_Reentrant {

    public static class Father {

        public synchronized void fatherDoSomeSthing(){
            System.out.println("father invoke fatherDoSomeSthing");
        }
    }

    public static class Son extends Father {

        public synchronized void sonDoSomeSthing(){
            fatherDoSomeSthing();
            System.out.println("son invoke sonDoSomeSthing");
        }

        @Override
        public synchronized void fatherDoSomeSthing() {
            super.fatherDoSomeSthing();
            System.out.println("son invoke fatherDoSomeSthing");
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.sonDoSomeSthing();
    }

}
