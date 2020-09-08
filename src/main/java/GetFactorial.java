
// главниый клас, что запрашивает ввод числа и вызывает функцию

import java.util.Scanner;

public class GetFactorial {

    public static void main(String[] args) {

        Scanner myscan = new Scanner(System.in); // Create a Scanner object

        System.out.print("Введите число для высчитывания его факториала: ");

        int number = myscan.nextInt();

        System.out.println("Факториал числа "+ number + " = " + Factorial.getNumber(number));

    }
}
