package ch1.base;

/**
 * 类说明: 创建线程的2种方式
 */
public class NewThread {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am extends Thread");
        }
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implement Runnable");
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }





}
