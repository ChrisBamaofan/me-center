import java.util.concurrent.CountDownLatch;

/**
 * @author zhaohaojie
 * @date 2019-03-25 23:22
 */
public class CountDown {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        Thread.sleep(2000);
        System.out.println("3");
    }

}

