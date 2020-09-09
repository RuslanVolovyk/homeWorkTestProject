
import java.util.Arrays;

public class RandomLoop {

    public static void main(String[] args) {

//  создания массива и логической переменной-флага
        int[] intArray = new int[10];
        boolean presentInArray = false;

//  блок заполнения массива рандомными значениями в диапазоне 1-100
        for (int i = 0; i < intArray.length; i++) {
            int number = (int) (Math.random() * 101);
            intArray[i] = number;
        }

//  блок прохождения через массив и вывод элемента массива равного 5
        for (int element : intArray)
            if (element == 5) {
                System.out.println(element);

//          флаг становится действительным, если искомый элемент найден
                presentInArray = true;
            }

//  вывод сообщения об неутешительных результатах поиска
        if (!presentInArray)
            System.out.println("Упсс.. элемента равного 5 в нашем массиве нету");

//  вывод элементов массива в консоль для наглядности и контроля
        System.out.println("Наш массив был таков: " + Arrays.toString(intArray));
    }
}
