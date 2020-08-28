package org.akanami.proxys;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo01 {
    public static void main(String[] args) {
        User user = new User("张三");

//        Class[] interfaces = new Class[]{ UserInterface.class};
//        User proxy = (User)Proxy.newProxyInstance(user.getClass().getClassLoader(), interfaces, new UserInvocationHandler(user));
        ProxyFactory factory = new ProxyFactory(user);
        UserInterface proxy = (UserInterface)factory.getProxyInstance();

        proxy.getName();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    interface UserInterface {
        String getName();
    }

    static class User implements UserInterface {
        String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            System.out.println("User getName:" + this.name);
            return this.name;
        }
    }
//
//    static class UserInvocationHandler implements InvocationHandler {
//        User user;
//
//        public  UserInvocationHandler(User user) {
//            this.user = user;
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("UserProxy invoke");
//            return method.invoke(this.user, args);
//        }
//    }

    static class ProxyFactory {
        private Object obj;

        public ProxyFactory(Object obj) {
            this.obj = obj;
        }

        public Object getProxyInstance() {
            return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(),
                    this.obj.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("开始事务2");
                            //执行目标对象方法
                            Object returnValue = method.invoke(obj, args);
                            System.out.println("提交事务2");
                            return returnValue;
                        }
                    });
        }
    }

}
