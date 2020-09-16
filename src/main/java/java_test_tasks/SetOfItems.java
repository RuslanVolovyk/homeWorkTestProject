package java_test_tasks;

import java.util.HashMap;

//  Клас- коллекцию из 4 объектов с ключами и методами
public class SetOfItems {

    // метод, что делает объект HashMap ключ - код, значение - объекты java_test_tasks.Item
    public static HashMap<String, Item> makeSet() {

        // создаем объект HashMap
        HashMap<String, Item> mySet = new HashMap<String, Item>();

        // создаем 4 елемента со значениями в объекте HashMap
        mySet.put("item1", new Item("ice-cream", 23));
        mySet.put("item2", new Item("table", 100));
        mySet.put("item3", new Item("ball", 32));
        mySet.put("item4", new Item("mouse", 76));

        return mySet;
    }

    // метод, что проверяет наличие елемента по введенному ключу в коллекции
    public static boolean isInSet(String keyCheck) {
        return SetOfItems.makeSet().containsKey(keyCheck);
    }

    // метод, что возвращает цену елемента с заданным кодом
    public static int getPrice(String keyCheck) {
        return SetOfItems.makeSet().get(keyCheck).getPrice();
    }

}

//  Клас товаров с полями  name и price
class Item {
    private final String name;
    private final int price;

    // конструктор товаров
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // метод, что возвращает цену товара
    public int getPrice() {
        return price;
    }

    // метод, что возвращает название товара
    public String getName() {
        return name;
    }
}
