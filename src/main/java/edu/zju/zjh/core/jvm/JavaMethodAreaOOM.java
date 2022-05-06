package edu.zju.zjh.core.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: zjh
 * @date : 2022/5/5 21:05
 * @Email : 2757412961@qq.com
 * @update:
 */

// 借助CGlib 使方法区出现永久代内存溢出异常，在JDK7中导致内存空间溢出
// java 8 不会出现问题
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(true);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{

    }

}
