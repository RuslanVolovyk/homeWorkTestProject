package java_test_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// главный класс пакета
public class FindByCode {

    // главный метод, что запрашивает данные и запускает методы для вывода результата
    public static void main(String[] args) {

        String newInput = "";

        System.out.print("Введите код товара для поиска (item1 - 4): ");

        //  буфер для считывания ввода
        InputStreamReader typedInput = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(typedInput);

        // оброботка возможных ошибок ввода
        try {
            newInput = buffer.readLine();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Упсс... произошла ошибка ввода");
        }


        if (SetOfItems.isInSet(newInput))
            System.out.println("Вы ввели " + newInput + ", его цена : " + SetOfItems.getPrice(newInput));
        else
            System.out.println("Упсс... не найдено " + newInput);


    }
}
