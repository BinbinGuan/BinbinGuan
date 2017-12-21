package item;

/**
 * @author GuanBin
 * @version Persen.java, v1 2017/12/14 下午4:55 GuanBin Exp $$
 */
public class Person {

    public Person(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String name;

    public String sex;

    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
