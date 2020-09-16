package java_test_tasks;

import java.util.Scanner;

public class FactorialByLoop {

    public static void main(String[] args) {

        Scanner myscan = new Scanner(System.in); // Create a Scanner object

        System.out.print("Введите число для высчитывания его факториала: ");

        int number = myscan.nextInt();

        FactorialByLoop newFactorialObject = new FactorialByLoop();

        System.out.println("Факториал числа " + number + " = " + newFactorialObject.Factorial(number));

    }

// метод для высчитывания факториала через цикл
    public long Factorial(int number) {
        long result = 1;
        if (number < 2)
            return result;
        else {
            for (int i = 2; i <= number; i++)
                result = result * i;
            return result;
        }
    }

}


