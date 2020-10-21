package org.akanami.spring.aop.aspectj.pure.demo01.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJPureAspect  {

    @Pointcut("within(org.akanami.spring.aop.aspectj.pure..*)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("call before");
    }
}
