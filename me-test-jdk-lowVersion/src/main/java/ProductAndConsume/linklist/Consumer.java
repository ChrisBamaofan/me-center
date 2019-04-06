package ProductAndConsume.linklist;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:49
 */
public class Consumer extends Thread{
    public MyStack myStack;
    public Consumer(MyStack myStack){
        this.myStack = myStack;
    }
    public void run(){
        try {
            myStack.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

