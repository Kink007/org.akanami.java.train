package org.akanami.proxy;

public class Demo01 {
    static class Worker {
        public void doSomething() {
            System.out.println("Work Do Something");
        }
    }

    static class WorkerProxy extends Worker {
        private Worker worker;

        public WorkerProxy(Worker worker) {
            this.worker = worker;
        }

        @Override
        public void doSomething() {
            System.out.println("WorkerProxy doSomething");
            this.worker.doSomething();
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        WorkerProxy workerProxy = new WorkerProxy(worker);

        workerProxy.doSomething();
    }
}
