package demo;

/**
 * Inturrupt的使用
 */
public class InterruptDemo {
    public static void main(String[] args) {
       //sleepThread睡眠1000ms
        final Thread sleepThread = new Thread() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               super.run();
           }
       };
       //busyThread一直死循环
        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while(true);
            }
        };
        sleepThread.start();
        busyThread.start();
        //sleepThread会清除中断标志位(抛出了InterruptException)
        //busyThread不会清除
        sleepThread.interrupt();
        busyThread.interrupt();
        while(sleepThread.isInterrupted());
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
