package demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class synchronizedDemo implements Runnable{

    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(new synchronizedDemo());
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result:" + count);
    }

    @Override
    public void run() {
        synchronized (synchronizedDemo.class) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

    }
}
