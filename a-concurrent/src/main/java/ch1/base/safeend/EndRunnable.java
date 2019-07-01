package ch1.base.safeend;

/**
 * 类说明: 实现接口Runnable的线程如何中断
 */
public class EndRunnable {

    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            //获取当前线程
            Thread currentThread = Thread.currentThread();
            String runnableName = Thread.currentThread().getName();
            System.out.println(runnableName +" Interrupted flag =" +currentThread.isInterrupted());
            //循环判断线程的标识位,调用isInterrupted() 来判断标识位,当线程调用方法被中断,返回true
//            while(!currentThread.isInterrupted()){
            //interrupted 静态方法 该方法会先判断是否中断，如果是true会先中断线程然后把标识位修改为false;
            while(!Thread.interrupted()){
                System.out.println(runnableName +" Interrupted flag =" +currentThread.isInterrupted());
            }
            System.out.println(runnableName +" Interrupted flag =" +currentThread.isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "myRunnable");
        thread.start();

        //线程休眠100毫秒
        Thread.sleep(100);
        //中断线程 起使就是把标识位修改为true
        thread.interrupt();

    }
}
