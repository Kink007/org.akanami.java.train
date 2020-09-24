package org.akanami.spring.ioc_1.bean_1_5_4;

/**
 * Spring的Bean是有scope属性的，表示bean的生存周期。
 * scope的值有prototype、singleton、session、request。
 * 那么就有个问题了，如果一个singleton的bean中引用了一个prototype的bean，结果会怎样呢？在默认情况下，单例会永远持有一开始构造所赋给它的值。
 *
 * 所以，为了让我们在每次调用这个Bean的时候都能够得到具体scope中的值，比如prototype，那么我们希望每次在单例中调用这个Bean的时候，得到的都是一个新的prototype，
 * Spring中AOP名字空间中引入了这个标签。 <aop:scoped-proxy/>
 */
public class ScopedProxyDemo {

}
