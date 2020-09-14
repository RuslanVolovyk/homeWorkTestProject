package java_test_tasks;
// главниый клас, что запрашивает ввод числа и вызывает функцию

import java.util.Scanner;

public class Factorial {
    public long getFuctorialNumber(int position) {
        if (position <= 1)
            return 1;
        return position * getFuctorialNumber(position - 1);
    }

    public static void main(String[] args) {

        Scanner myscan = new Scanner(System.in); // Create a Scanner object

        System.out.print("Введите число для высчитывания его факториала: ");

        int number = myscan.nextInt();

        Factorial anFactorialObject = new Factorial();

        System.out.println("Факториал числа " + number + " = " + anFactorialObject.getFuctorialNumber(number));


    }
}
