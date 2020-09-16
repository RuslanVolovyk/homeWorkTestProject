package java_test_tasks;

import java.io.*;

public class CaseSelect {

    public static void main(String[] args) {
//  переменные для работы
        String newInput = "";
        float time, money;
//  блок ввода данных (время, деньги)
        System.out.print("Введите время и деньги через пробел (пример: 13.45 50.45): ");
        InputStreamReader typedInput = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(typedInput);

//  блок оброботки ошибок ввода данных
        try {
            newInput = buffer.readLine();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Упсс... произошла ошибка ввода");
        }

        String[] StringArray = newInput.split(" ");

//  обработка корректности введенных данных
        try {
            time = Float.parseFloat(StringArray[0]);
            money = Float.parseFloat(StringArray[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException nfe) {
            System.out.println("вводить только время (0-24) и деньги через пробел (пример: 13.45 50.45):");
            return;
        }

        if (time > 24 || time < 0 || money < 0) {
            System.out.println(" чувак, время не может быть меньше 0 и больше 24 (0-24), а деньги - меньше 0");
            return;
        }

//  блок обработки условий
        if (time >= 8 && time <= 12)
            if (money > 10)
                System.out.println("Идем в магазин!");
            else
                System.out.println("В условии не указано, что делать");
        else if (time > 12 && time <= 19)
            if (money > 50)
                System.out.println("Идем в кафе!");
            else
                System.out.println("Идем к соседу");
        else if (time > 19 && time <= 22)
            System.out.println("Смотрим телевизор");
        else
            System.out.println("Идем спать");

    }
}
