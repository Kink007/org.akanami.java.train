package org.akanami.spring.aop.aspectj.annotation.demo01.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
       execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
                throws-pattern?)

         *最常用作返回类型模式。它匹配任何返回类型。
         仅当方法返回给定类型时，标准类型名称才匹配。
         名称模式与方法名称匹配。您可以将*通配符用作名称模式的全部或一部分。
         如果您指定一个声明类型模式，请在其后加上尾随。
         将其加入名称模式组件。
         参数模式稍微复杂一些：
         （）匹配不带参数的方法，
         而（..）匹配任意数量（零个或多个）的参数。
         （*）模式与采用任何类型的一个参数的方法匹配。
         （*，String）与采用两个参数的方法匹配。第一个可以是任何类型，而第二个必须是字符串。有关更多信息，请查阅AspectJ编程指南的“语言语义”部分。

        一般来说:
            * 表示任意一个
            .. 表示0个到多个

        例子：
            所有public方法     execution(public * *(..))
            所有名字set开头的方法  execution(* set*(..))
            所有由AccountService接口定义的方法  execution(* com.xyz.service.AccountService.*(..))
            所有service包定义的方法 execution(* com.xyz.service.*.*(..))
            所有service包以及其子包定义的方法 execution(* com.xyz.service..*.*(..))
            所有service包定义的方法(只能在Spring AOP中使用) with(com.xzy.service.*)
            所有service包以及其子包定义的方法(只能在Spring AOP中使用) with(com.xyz.service..*)
            所有AccountService接口定义的方法(只能在Spring AOP中使用) this(com.xyz.service.AccountService)    // Any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
            Any join point (method execution only in Spring AOP) where the target object implements the AccountService interface: target(com.xyz.service.AccountService)
            Any join point (method execution only in Spring AOP) that takes a single parameter and where the argument passed at runtime is Serializable: args(java.io.Serializable)
                Note that the pointcut given in this example is different from execution(* *(java.io.Serializable)). The args version matches if the argument passed at runtime is Serializable, and the execution version matches if the method signature declares a single parameter of type Serializable
            Any join point (method execution only in Spring AOP) where the target object has a @Transactional annotation: @target(org.springframework.transaction.annotation.Transactional)
            Any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:  @with(org.springframework.transaction.annotation.Transactional)
            Any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation: @annotation(org.springframework.transaction.annotation.Transactional)
            Any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation: @args(com.xyz.security.Classified)
            Any join point (method execution only in Spring AOP) on a Spring bean named tradeService:  bean(tradeService)
            Any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression *Service:   bean(*Service)
 */

@Aspect
@Component
public class NormalAspect {

    //@Pointcut("execution(* sayHello(..))")
    //@Pointcut("execution(* *(..))")
    //@Pointcut("execution(public * *(..))")
    @Pointcut("execution(public * sayHello(..))")
    public void pointCut() {
        System.out.println("call pointCut");
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before pointcut");
    }

    @Pointcut("within(org.akanami.spring.aop.aspectj.annotation.demo01.service..*)")
    public void withinCut() {

    }

    @Before("withinCut()")
    public void beforeService() {
        System.out.println("beforeService Call withCut");
    }
}
