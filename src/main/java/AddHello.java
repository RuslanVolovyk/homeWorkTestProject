import java.util.*;

public class AddHello {

    public static void main(String[] args) {
//  Начальный массив строк
        String[] strArray = {"A first sentence", "The second sentence", "The last sentence"};

//  цикл перебора элементов массива и их модификации
        for (int i = 0; i < strArray.length; i++) {

//      модификация и замена элемента массива
            strArray[i] = strArray[i].concat(" hello");

        }
//  вывод модифицированного массива
        System.out.println(Arrays.toString(strArray));
    }
}

