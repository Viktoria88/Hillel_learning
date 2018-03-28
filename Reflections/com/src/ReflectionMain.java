import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectionMain {
    public static void main(String[] args) {

        // 1. Creating new Class Instance with constructor Map.class

        Class<? extends Object> myClass = HashMap.class;
        try {
            HashMap hash1 = (HashMap) myClass.getDeclaredConstructor(Map.class).newInstance(putHashMap);
            System.out.println(hash1);
            // 1.1. Print all exist constructors
            Constructor[] constructors = myClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println("Constructor: " + constructor);
            }
            // 1.2. Print elements ??
            Set parameters = hash1.entrySet();
            for (Object entry : parameters) {
                System.out.println("Elements: " + parameters);
            }
            // 1.3. Parent class
            System.out.println("Parent class HashMap: " + myClass.getSuperclass());
            // 1.4. Interfaces
            Object[] interfaces = myClass.getInterfaces();
            for (Object obj : interfaces) {
                System.out.println("Interface HashMap: " + obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Public method and Fields in ArrayList

        ArrayList arr = new ArrayList();
        Class cArr = arr.getClass();
        Field[] fields = cArr.getFields();
        for (Field field : fields) {
            System.out.println("\nPublic fields: " + field.getName());
        }
        Method[] methods = cArr.getMethods();
        for (Method method : methods) {
            System.out.println("Public methods: " + method.getName());
        }

        // 3. MyClass change

        MyClass myCla = new MyClass();
        Class c = myCla.getClass();
        try {
            Method method = c.getDeclaredMethod("privateMethod", String.class);
            method.setAccessible(true);
            Method[] methods1 = c.getDeclaredMethods();
            for (Method method1 : methods1) {
                System.out.println("Methods: " + method1.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 1.111111. Creating new Class Instance with empty constructor

        HashMap hashMap = new HashMap();
        HashMap hash = null;
        try {
            hash = create(hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hash);
    }

    private static Map<String, String> putHashMap = new HashMap<String, String>();

    static {
        putHashMap.put("Some", "Thing");
        putHashMap.put("Add", "In map");
    }

    public static <T> T create(T ex) {
        try {

            return (T) ex.getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
