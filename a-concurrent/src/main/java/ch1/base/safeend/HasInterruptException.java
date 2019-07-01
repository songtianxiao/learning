package ch1.base.safeend;

/**
 * 类说明: 阻塞方法中抛出InterruptedException异常后，如果需要继续中断，需要手动再中断一次
 */
public class HasInterruptException {

    private static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            String name = this.getName();
            System.out.println("my name is"+name+"extend Thread");

            while (!this.isInterrupted()) {
                System.out.println(name+" interrupted flag = " + this.isInterrupted());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(name+" InterruptedException flag = " + this.isInterrupted());
                    //sleep方法会检测线程标识符isInterrupted 是否true(中止)
                    //如果为true 会抛出InterruptedException 异常
                    //并且 标识符isInterrupted 标识位再次修改为false
                    //所以需要再次调用中止线程的方法
                    this.interrupt();
                    e.printStackTrace();
                }
                System.out.println(name+" interrupted flag = " + this.isInterrupted());

            }

            System.out.println(name+" interrupted flag = " + this.isInterrupted());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("myThread");
        myThread.start();

        Thread.sleep(500);
        //中断线程
        myThread.interrupt();


    }
}
