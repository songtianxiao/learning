package ch1.syn;

/**
 * 类说明:
 */
public class SynTest {

    private long count = 0;
    private Object obj = new Object();


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    /*用在同步块上*/
    public void incCount(){
        //synchronized (obj) {
            count++;
        //}
    }

    /*用在方法上*/
    public synchronized void incCount2(){
        count++;
    }

    /*用在同步块上，但是锁是当前对象实例*/
    public void incCount3(){
        synchronized (this) {
            count++;
        }
    }

    private static class MyThread extends Thread {

        private SynTest synTest;

        public MyThread(SynTest synTest) {
            this.synTest = synTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synTest.incCount();
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
       SynTest synTest = new SynTest();
       MyThread t1 = new MyThread(synTest);
       MyThread t2 = new MyThread(synTest);
       t1.start();
       t2.start();
       Thread.sleep(1000);
       System.out.println(synTest.count);
    }
}
