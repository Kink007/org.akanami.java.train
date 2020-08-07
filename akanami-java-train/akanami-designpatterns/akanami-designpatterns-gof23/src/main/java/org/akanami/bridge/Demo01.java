package org.akanami.bridge;

import java.util.Optional;

public class Demo01 {
    static interface Implementer {
        void OperationImpl();
    }

    static class AbstractImplementer implements Implementer {
        Implementer implementer;

        public AbstractImplementer(Implementer implmentor) {
            this.implementer = implmentor;
        }

        public void OperationImpl() {
            this.implementer.OperationImpl();
        }
    }

    static class ConcreteImplementer implements Implementer{
        @Override
        public void OperationImpl() {
            System.out.println("ConcreteImplementer Call");
        }
    }

    static class ConcreteImplementerA implements Implementer {
        @Override
        public void OperationImpl() {
            System.out.println("ConcreteImplementerA Process");
        }
    }

    static class ObjectImplementer extends AbstractImplementer {
        Implementer implementor;

        public ObjectImplementer(Implementer implementer) {
            super(implementer);
        }

        public void setImplementor(Implementer implementor) {
            this.implementor = implementer;
        }

        public void OperationImpl() {
            this.implementor.OperationImpl();
        }
    }

    public static void main(String[] args) {
        ConcreteImplementer implementer = new ConcreteImplementer();
        ObjectImplementer objectImplementer = new ObjectImplementer(implementer);
        objectImplementer.OperationImpl();
    }
}
