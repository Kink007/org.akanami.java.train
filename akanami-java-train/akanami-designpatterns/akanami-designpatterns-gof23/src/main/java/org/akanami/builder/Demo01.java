package org.akanami.builder;

import org.akanami.common.MockObject;

/*
    建造者（Builder）模式的主要角色如下。
    产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
    抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
    具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
    指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class Demo01 {
    static class Product {
        private MockObject PartA;
        private MockObject PartB;
        private MockObject PartC;

        public void setPartA(MockObject partA) {
            PartA = partA;
        }

        public void setPartB(MockObject partB) {
            PartB = partB;
        }

        public void setPartC(MockObject partC) {
            PartC = partC;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "PartA=" + PartA +
                    ", PartB=" + PartB +
                    ", PartC=" + PartC +
                    '}';
        }

        public void Show() {
            System.out.println("Product Show:" + this.toString());
        }
    }

    static abstract class Builder {
        protected Product product = new Product();

        public abstract void buildPartA();

        public abstract void buildPartB();

        public abstract void buildPartC();

        public Product getProduct() {
            return product;
        }
    }

    static class ConcreteBuilder extends Builder {
        @Override
        public void buildPartA() {
            product.setPartA(new MockObject("partA"));
        }

        @Override
        public void buildPartB() {
            product.setPartB(new MockObject("partB"));
        }

        @Override
        public void buildPartC() {
            product.setPartC(new MockObject("partC"));
        }
    }

    static class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product construct() {
            this.builder.buildPartA();
            this.builder.buildPartB();
            this.builder.buildPartC();

            Product product = this.builder.getProduct();
            return product;
        }
    }

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.construct();
        System.out.println("构造完成:" + product);
    }
}
