package ch1.base;

/**
 * 类说明: join方法演示
 */
public class JoinDemo {

    private static class MyThread1 extends Thread {

        private Thread thread;

        public MyThread1(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {

            System.out.println(this.getName()+" start.... " );

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+" end.... " );
        }
    }

    private static class MyThread2 extends Thread {
        public MyThread2(String name) {
            super(name);
        }

        @Override
        public void run() {

            System.out.println(this.getName()+" start.... " );

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName()+" end.... " );
        }
    }

    public static void main(String[] args) throws InterruptedException {
       MyThread2 myThread2 = new MyThread2("myThread2");
       MyThread1 myThread1 = new MyThread1(myThread2);
       myThread1.setName("myThread1");
        myThread2.start();
        myThread1.start();
       myThread1.join();
        System.out.println("main......end......");
    }
}
