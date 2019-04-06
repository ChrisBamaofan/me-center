package ProductAndConsume.linklist;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:50
 */
public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Product product  = new Product(myStack);
//        Consumer consumer = new Consumer(myStack);
//        product.start();
//        consumer.start();
        String str= new String("");
        System.out.println(str instanceof Object);
        System.out.println(myStack instanceof Object);
        System.out.println(product instanceof Object);
    }
}

