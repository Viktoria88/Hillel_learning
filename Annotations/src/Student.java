import Annotations.Person;
import Annotations.PersonalDate;
import Annotations.Sex;

import static Annotations.Person.Status.STUDENT;
import static Annotations.Sex.SexEnum.MALE;

@Person(status = STUDENT)
public class Student {

    private String name;
    private int age;

    @Sex(sexEnum = MALE)
    Annotations.Sex.SexEnum Sex;

    @PersonalDate(name = "Tony", age = 20)
    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

}
