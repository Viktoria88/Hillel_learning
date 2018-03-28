import Annotations.Person;
import Annotations.PersonalDate;
import Annotations.Sex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) {

        Student student = new Student();
        Class c = student.getClass();

        Annotation[] annotations;

        annotations = c.getAnnotations();
        for (Annotation a : annotations) {
            if (a.annotationType().equals(Annotations.Person.class)) {
                Person.Status s = ((Person) a).status();
                System.out.println(s);
            }
        }

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            annotations = m.getDeclaredAnnotations();
            for (Annotation a : annotations){
                if (a.annotationType().equals(Annotations.PersonalDate.class)){
                    String name = ((PersonalDate) a).name();
                    int age = ((PersonalDate) a).age();
                    String adress = ((PersonalDate) a).adress();
                    System.out.println("Name: " + name +  "\nAge: " + age + "\nAdress: " + adress);
                }
            }
        }

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            annotations = f.getDeclaredAnnotations();
            for (Annotation a : annotations){
                if (a.annotationType().equals(Annotations.Sex.class)){
                    Sex.SexEnum sex = ((Sex) a).sexEnum();
                    System.out.println(sex);
                }
            }
        }
    }

}
