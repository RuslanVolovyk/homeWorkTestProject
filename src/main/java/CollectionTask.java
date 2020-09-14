import java.util.HashMap;
import java.util.HashSet;

public class CollectionTask {

    public static void main(String[] args) {

//  создаем HashMap с названием animalSound (ключ - животное, значение звук животного )
        HashMap<String, String> animalSound = new HashMap<>();

//  добавляем 3 элемента в созданный HashMap с названием animalSound
        animalSound.put("Dog", "gav-gav");
        animalSound.put("Cat", "meow-meow");
        animalSound.put("Rooster", "Cocka-doodle-doo");

//Выводим в консоль HashMap animalSound
        for (String hasMapString : animalSound.keySet()) {
            System.out.println("key: " + hasMapString + " value: " + animalSound.get(hasMapString));
        }

//  создаем Set с названием integerHashSet (значения - обертки примитива целого числа )
        HashSet<Integer> integerHashSet = new HashSet<>();

        //  Передаем в Set 2 одинаковых значения
        integerHashSet.add(2);
        integerHashSet.add(2);

        System.out.println("Set  integerHashSet: " + integerHashSet);

    }

}
