package org.akanami.spring.aop.jdk.java.demo02.service.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DemoBeforeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("call DemoBeforeAdvice invoke");

        return methodInvocation.proceed();
    }
}
