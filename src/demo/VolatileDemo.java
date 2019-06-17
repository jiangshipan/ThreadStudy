package demo;

public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while(!isOver);
            System.out.println("end...");
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //main把isOver改为true后,thread工作内存中该变量值就会失效
        isOver = true;
    }
}
