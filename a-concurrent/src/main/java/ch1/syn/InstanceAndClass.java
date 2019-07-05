package ch1.syn;

/**
 * 类说明: 类锁和对象锁是不同的 ,可以并行
 */
public class InstanceAndClass {


    private static class Instance extends Thread {
        private InstanceAndClass instanceAndClass;

        public Instance(InstanceAndClass instanceAndClass) {
            this.instanceAndClass = instanceAndClass;
        }

        @Override
        public void run() {
            System.out.println("Instance......go....");
            instanceAndClass.instance1();

        }
    }
    private static class ClassSyn extends Thread {

        @Override
        public void run() {
            System.out.println("ClassSyn......go....");
            instance2();
        }
    }

    public synchronized void instance1(){
        System.out.println("instance1.......go.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("instance1.......end.......");
    }
    public synchronized static void instance2(){
        System.out.println("instance2.......go.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("instance2.......end.......");
    }

    public static void main(String[] args){
       ClassSyn t1 = new ClassSyn();
       InstanceAndClass instanceAndClass = new InstanceAndClass();
       Instance t2 = new Instance(instanceAndClass);

       t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();



    }
}
