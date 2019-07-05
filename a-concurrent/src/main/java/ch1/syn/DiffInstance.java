package ch1.syn;

/**
 * 类说明:锁的实例不一样是可以并行的
 */
public class DiffInstance {

    public synchronized void instance() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("instance...go...."+this.toString());
        Thread.sleep(1000);
        System.out.println("instance...end...."+this.toString());

    }
    public synchronized void instance2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("instance2...go...."+this.toString());
        Thread.sleep(1000);
        System.out.println("instance2...end...."+this.toString());
    }

    private static class InstanceSyn extends Thread {

        private DiffInstance diffInstance;

        public InstanceSyn(DiffInstance diffInstance) {
            this.diffInstance = diffInstance;
        }

        @Override
        public void run() {
            try {
                diffInstance.instance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     private static class InstanceSyn2 extends Thread {
         private DiffInstance diffInstance;

         public InstanceSyn2(DiffInstance diffInstance) {
             this.diffInstance = diffInstance;
         }
        @Override
        public void run() {
            try {
//                diffInstance.instance2();
                diffInstance.instance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){

        DiffInstance d1 = new DiffInstance();
        InstanceSyn instanceSyn = new InstanceSyn(d1);
        DiffInstance d2 = new DiffInstance();
        InstanceSyn instanceSyn2 = new InstanceSyn(d2);

        instanceSyn.start();
        instanceSyn2.start();

    }


}
