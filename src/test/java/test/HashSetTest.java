package test;

import com.idcos.Application;
import item.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author GuanBin
 * @version HashSetTest.java, v1 2017/12/14 下午5:00 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class HashSetTest {
    @Test
    public void test(){
        List<Person> personList=new ArrayList<>();
        Person person=new Person("Tom","男","18");
        Person person1=new Person("Jerry","女","21");
        Person person2=new Person("Tom","男","18");
        personList.add(person);
        personList.add(person1);
        personList.add(person2);

        Set<Person>  personSet=new HashSet<>(personList);
        System.out.println("***************"+personSet.size());
        for(Person per:personSet){
            System.out.println("***************"+per.getName());
        }

    }
}
