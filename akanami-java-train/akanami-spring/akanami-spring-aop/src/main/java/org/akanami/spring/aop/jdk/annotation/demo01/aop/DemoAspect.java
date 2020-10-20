package org.akanami.spring.aop.jdk.annotation.demo01.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect {

    @Pointcut("execution(* sayHello(..))")
    public void pointCut() {
        System.out.println("pointcut call");
    }

    @Before("pointCut()")
    public void aspectBefore() {
        System.out.println("aspectBefore");
    }

    @After("pointCut()")
    public void aspectAfter() {
        System.out.println("aspectAfter");
    }
}
