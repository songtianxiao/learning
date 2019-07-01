package ch1.base;

/**
 * 类说明:
 */
public class DaemonThread {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                while (true) {
                    System.out.println("I am extends Thread...");
                }
            }finally {
                //守护线程finally有一定几率不执行
                System.out.println("finally......");
            }
        }
    }

    //把启动线程和设置守护线程放在静态块中
    static {
        MyThread myThread = new MyThread();
        //在线程启动之前设置为守护线程
        myThread.setDaemon(true);
        myThread.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
        //在线程启动之前设置为守护线程
//        myThread.setDaemon(true);
//        myThread.start();
        Thread.sleep(100);
    }
}
