package ProductAndConsume;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:17
 */
public class Main {
    public static void main(String[] args) {
        String lck ="";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Producter producter = new Producter(lck);
                try {

                    producter.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Consumer consumer = new Consumer(lck);
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

