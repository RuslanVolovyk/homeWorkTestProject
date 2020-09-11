import java.io.*;

public class ExceptionTack {
    public static void main(String[] args) {
//      Деление на 0
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Ай-я-яй, снова делил на 0, да!?");
        } finally {
            System.out.println("Я исполняюсь пока JVM не выключена");
        }

// обработка исключений с Null Pointer и File IO
        try {
            FileReader testFile = new FileReader("no_such_file.txt");
            Object obj = null;
            obj.hashCode();
        } catch (NullPointerException | FileNotFoundException e) {

//      Вывод на экран трасировки ошибок
            e.printStackTrace();
        }


    }
}
