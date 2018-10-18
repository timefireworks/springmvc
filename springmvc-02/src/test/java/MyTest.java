/**
 * author: San Jinhong
 * date: 2018/9/27 14:41
 **/
public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());

//        Class clazz = Class.forName("com.test.Hello");
//        System.out.println(clazz.getClassLoader());

        MyTest myTest  = new MyTest();
        System.out.println(myTest.getClass().getClassLoader());
        System.out.println(myTest.getClass().getClassLoader().getParent());
        System.out.println(myTest.getClass().getClassLoader().getParent().getParent());


    }
}
