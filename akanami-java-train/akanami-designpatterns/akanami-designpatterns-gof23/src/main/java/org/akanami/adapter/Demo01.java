package org.akanami.adapter;

public class Demo01 {
    static class Worker {
        public void doSomething() {
            System.out.println("worker do something");
        }
    }

    static class WorkerAdapter {
        Worker worker = new Worker();

        public void doSpecialSomething() {
            System.out.println("WorkerAdapter doSpecialSomething");

            this.worker.doSomething();
        }
    }

    public static void main(String[] args) {
        WorkerAdapter adapter = new WorkerAdapter();
        adapter.doSpecialSomething();
    }
}
