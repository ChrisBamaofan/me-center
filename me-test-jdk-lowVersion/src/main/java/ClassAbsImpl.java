/**
 * @author zhaohaojie
 * @date 2019-03-24 11:21
 */
public class ClassAbsImpl extends ClassAbs {
    @Override
    public void dosom() {
        System.out.println("in class classabs impl and class loader is "+System.class.getClassLoader());
        System.out.println(this.getClass().getClassLoader());
    }

    @Override
    public void dome2() {

    }

}

