package ProductAndConsume.linklist;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:48
 */
public class Product extends Thread{
    MyStack stack;
    public Product(MyStack stack){
        this.stack = stack;
    }
    public void run(){
        try {
            stack.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

