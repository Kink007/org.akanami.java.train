package org.akanami.spring.aop.jdk.demo01.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
public class AspectService implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Method:" + method + " Objects:" + objects + " Object:" + o);
    }
}
