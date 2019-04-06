import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhaohaojie
 * @date 2019-03-20 11:32
 */
public class TestSerialize implements Serializable {
    public String name;
    public Integer age;
    public LocalDateTime time;

    public TestSerialize(String name,Integer age,LocalDateTime dateTime){
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void saysm(){
        System.out.println("i am "+name+",i am "+age+" years old.");
    }

    @Override
    public String toString() {
        return this.name + ","+this.age+","+this.time;
    }
}

