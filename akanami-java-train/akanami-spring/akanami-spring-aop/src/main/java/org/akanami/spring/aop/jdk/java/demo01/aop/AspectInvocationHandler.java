package org.akanami.spring.aop.jdk.java.demo01.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AspectInvocationHandler implements InvocationHandler {
    private Object obj;

    public AspectInvocationHandler(Object o) {
        this.obj = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        //Object result = method.invoke(proxy, args); //使用proxy，会递归无限循环重复调用invoke方法，因为这里proxy已经是代理类了
        Object result = method.invoke(this.obj, args);
        System.out.println("after invoke");

        return result;
    }
}
