/**
 * @author zhaohaojie
 * @date 2019-03-24 15:03
 */
public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }


    static class Sub extends Base {
        private String baseName = "sub";

        public void callName(String name) {

            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}

