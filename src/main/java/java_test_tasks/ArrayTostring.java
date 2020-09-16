package java_test_tasks;

import java.util.*;

public class ArrayTostring {

        public static void main(String[] args) {

//   Мой стартовый массив строк
            String[] stringArray = {"Hi", "I", "am", "a", "string", "array"};

//   Моя строка
            String myString = "Hi I am just a plain string.";

// вывод в консоль массива проконвертированного в строку методом массива
            System.out.println(Arrays.toString(stringArray));

// создание объекта стрингбилдера и присоединение массива
            StringBuilder stringBuild = new StringBuilder().append(stringArray);

// вывод в консоль строки стрингбилдера
            System.out.println(stringBuild);

// создание массива строк с моей начальной строки
            String[] nextStringArray = myString.split(" ");

// вывод в консоль последнего массива строк проконвертированного в строку методом массива
            System.out.println(Arrays.toString(nextStringArray));


        }
    }
