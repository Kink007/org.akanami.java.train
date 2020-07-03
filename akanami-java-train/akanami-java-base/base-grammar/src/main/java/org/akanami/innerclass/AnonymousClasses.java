package org.akanami.innerclass;

public class AnonymousClasses {

    interface Hello {
        public void greet();

        public void greet(String name);
    }

    public void sayHello() {
        class EnglishGreeting implements Hello {
            String prefix = "hello";

            @Override
            public void greet() {
                System.out.println("greet:" + this.prefix);
            }

            @Override
            public void greet(String name) {
                System.out.println("greet:" + this.prefix + " to " + name);
            }
        }

        class ChineseGreeting implements Hello {
            String prefix = "你好";

            @Override
            public void greet() {
                System.out.println("greet:" + this.prefix);
            }

            @Override
            public void greet(String name) {
                System.out.println("greet:" + this.prefix + " to " + name);
            }
        }

        Hello engHello = new EnglishGreeting();
        Hello chiHello = new ChineseGreeting();

        engHello.greet();
        chiHello.greet();
    }

    public static void main(String[] args) {
        AnonymousClasses anonymousClasses = new AnonymousClasses();
        anonymousClasses.sayHello();
    }
}
