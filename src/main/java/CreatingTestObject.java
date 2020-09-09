import java.util.Objects;


// Создаем клас ТЕСТ
class Test {

//клас имеет одну переменную - название
    private String objectName = "basic";

// Создаем метод-конструктор с одним параметром
    public Test(String word){
        this.objectName = word;
    }
}

// Создаем главные клас для запуска программы
public class CreatingTestObject {

// Главная функция для запуска программы
    public static void main(String[] args) {

// Создаем 2 экземпляра класса ТЕСТ и передаем в них по аргументу
        Test test1 = new Test("first");
        Test test2 = new Test("second");

    }
}
