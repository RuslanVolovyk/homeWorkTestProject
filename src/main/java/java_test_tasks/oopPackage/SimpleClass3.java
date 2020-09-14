package java_test_tasks.oopPackage;

// Класс1 - предок для класса2
class SimpleClass1 {
    String className = "Class 1";

//   3 методы с разными модификаторами доступа

    public void publicMethod() {
        System.out.println("I am public method from " + className);
    }

    private void privateMethod() {
        System.out.println("I am private method from " + className);

    }

    protected void protectedMethod() {
        System.out.println("I am protected method from " + className);
    }
}

// Класс2 наследник класса1
class SimpleClass2 extends SimpleClass1 {

//    Вызов методов класса предка
    public  void demoMethod(){
      publicStatic();
      publicMethod();
    }


    //    Паблик статик метод
    public static void publicStatic() {
        System.out.println("I am public static method from " + SimpleClass2.class.getName());
        publicStatic();

    }

}


// Класс3
public class SimpleClass3 {

    //    Главная запускная фнкция
    public static void main(String[] args) {

//     Вызоз доступных методов пакета
        new SimpleClass1().publicMethod();
        new SimpleClass1().protectedMethod();

//     Вызов паблик статик метода из класса2
        SimpleClass2.publicStatic();

    }

}
