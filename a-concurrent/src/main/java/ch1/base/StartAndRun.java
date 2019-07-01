package ch1.base;

/**
 * 类说明: start 和 run 的区别
 */
public class StartAndRun {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" I am extends Thread");
        }
    }

    public static void main(String[] args){
       MyThread thread  = new MyThread();

       thread.start();

       thread.run();

    }



}
