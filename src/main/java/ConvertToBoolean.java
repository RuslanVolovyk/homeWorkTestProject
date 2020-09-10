import java.util.*;

public class ConvertToBoolean {

    public static void main(String[] args) {

//  начальный массив целых чисел
        int[] intArray = {1, -3, 4, 0, 5, 5, -5, 6, 6, 0, 0, 0, 50, 0};

//  созданее булевого массива и конвертация в него через поток используя лямбда-функцию
//  0 - false, иные значения  - true
        Boolean[] boolArray = Arrays.stream(intArray).mapToObj(i -> i != 0).toArray(Boolean[]::new);

//  вывод булевского массива в кансоль
        System.out.println(Arrays.toString(boolArray));

    }
}

