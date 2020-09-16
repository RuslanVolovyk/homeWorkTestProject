package java_test_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// главный класс пакета
public class EvenOdd {

    // главный метод, что запрашивает консольный ввод данных и проверяет их
    public static void main(String[] args) {

// переменные
        String newInput = "";
        int n;

// запрос ввода
        System.out.print("Пожалуйста введи целое число для переменной n: ");

//  инициализация потока и буфера консольного ввода
        InputStreamReader typedInput = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(typedInput);

//        обработка возможных ошибок ввода
        try {
            newInput = buffer.readLine();
            buffer.close();

//            вывод сообщения об ощибке ввода
        } catch (IOException e) {
            System.out.println("Упсс... произошла ошибка ввода");
        }

//        проверка на то являются ли введенные данные целочисельными
        try {
            n = Integer.parseInt(newInput);

//            вывод сообщения обошибке типа введенных данных
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Вводить нужно только целые числа");

//            завершение программы при неверном вводе
            return;
        }

//        блок проверки введенного числа на четность и на 0, и вывод результата в консоль
        if (n % 2 == 0 && n != 0)
            System.out.println("Введенное число " + n + " четное");
        else if (n != 0)
            System.out.println("Введенное число " + n + " нечетное");
        else
            System.out.println("Введенное число " + n + " не может быть обработано!");


    }
}

