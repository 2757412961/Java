package edu.zju.zjh.gof23.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zjh
 * @date : 2021/4/1 20:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ProxyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void setRent(Object obj) {
        this.obj = obj;
    }

    /**
     * @Description: 生成代理对象
     * @Param: []
     * @return: java.lang.Object
     * @Author: zjh
     * @Date: 2021/4/1
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.obj.getClass().getInterfaces(), this);
    }

    /**
     * @Description: 处理代理实例
     * @Param: [proxy, method, args]
     * @return: java.lang.Object
     * @Author: zjh
     * @Date: 2021/4/1
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object invoke = method.invoke(obj, args);

        return invoke;
    }

    public void log(String str) {
        System.out.println(str);
    }
}
