package edu.zju.zjh.core.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author: zjh
 * @date : 2022/5/9 9:42
 * @Email : 2757412961@qq.com
 * @update:
 */

public class WeakReferenceTest {

    public static void main(String[] args) {
        Object referent = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        WeakReference weakReference1 = new WeakReference<>(referent);
        WeakReference weakReference2 = new WeakReference<>(referent, referenceQueue);

        referent = null;
        System.gc();

        Object referent1 = weakReference1.get();
        Object referent2 = weakReference2.get();
        System.out.println("after gc, reference get result: " + referent1);
        System.out.println("after gc, reference get result: " + referent2);
        Reference<?> reference = referenceQueue.poll();
        System.out.println("after gc, reference queue get result: " + reference.get());
    }

}
