package java_test_tasks;

public class Constructor {

    //  дефолтный коструктор в котором будет выводится имя класса
    Constructor() {
        System.out.println(getClass());
    }

    //  второй конструктор в котором будет выводится имя класса и названия того кто его делал
    Constructor(String ownerName) {
        System.out.println(getClass() + " сделано " + ownerName);


    }

    public static void main(String[] args) {

//  создание объектов класса для проверки конструкторов
        Constructor testObjectOfThisClass = new Constructor();
        Constructor secondTestObjectOfThisClass = new Constructor("Maksym");
    }
}
