package ch1.base;

/**
 * 类说明: 测试Sleep对锁的影响
 * 线程sleep 不会释放锁，
 */
public class SleepLock {

    private static final Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
           ThreadSleep threadSleep = new ThreadSleep("threadSleep");
           ThreadNotsleep threadNotsleep = new ThreadNotsleep("threadNotSleep");
           threadSleep.start();
           Thread.sleep(1000);
           threadNotsleep.start();
    }

    private static class ThreadSleep extends Thread {
        public ThreadSleep(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("ThreadSleep start...");
                try {
                    Thread.sleep(5000);
                    System.out.println(this.getName()+" end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadNotsleep extends Thread {
        public ThreadNotsleep(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("ThreadNotSleep start...");
            long startTime = System.currentTimeMillis();
            System.out.println(this.getName()+":"+startTime);
            synchronized (lock) {
                //因为两个线程都是使用同一把锁，所以需要等待休眠的线程执行完把锁释放
                System.out.println(this.getName()+":"+(System.currentTimeMillis()-startTime));
                System.out.println("ThreadNotSleep end....");
            }

        }
    }



}
