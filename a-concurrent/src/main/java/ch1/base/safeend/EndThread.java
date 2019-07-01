package ch1.base.safeend;

/**
 * 类说明: 如何安全中止一个线程
 */
public class EndThread {

    private static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = this.getName();
            System.out.println(threadName+" interrupted flag " + this.isInterrupted());
            //循环判断线程的标识位,调用this.isInterrupted() 来判断标识位,当线程调用方法被中断,返回true
            while(!this.isInterrupted()){
                System.out.println(threadName+" interrupted flag " + this.isInterrupted());
            }
            System.out.println(threadName+" interrupted flag " + this.isInterrupted());

        }
    }

    public static void main(String[] args) throws InterruptedException {
       MyThread myThread = new MyThread("endThread");
       myThread.start();
       //休眠线程100毫秒
       Thread .sleep(100);
       //调用myThread线程的中止方法
       myThread.interrupt();
    }
}
