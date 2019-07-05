package ch1.syn;

/**
 * 类说明:
 */
public class TestIntegerSyn {



    public static void main(String[] args){

        Work w = new Work(1);
        for (int i = 0; i < 5; i++) {
            new Thread(w).start();
        }


    }

    private static class Work implements  Runnable {

        private Integer i;
        //线程锁 是不能变得
        private Object o = new Object();

        public Work(Integer i) {
            this.i = i;
        }

        public void run() {

            synchronized (o){
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() +"--@"+i+"--" + System.identityHashCode(i) );
                i++;
                System.out.println(thread.getName() +"--@--" + System.identityHashCode(i) );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                System.out.println(thread.getName() +"--@--" + System.identityHashCode(i) );
            }

        }
    }



}
