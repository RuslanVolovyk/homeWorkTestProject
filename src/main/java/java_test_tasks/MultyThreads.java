package java_test_tasks;

public class MultyThreads extends Thread {

    //  метод для многопоточной генерации
    public void intDataGenerator() {

//  создание целочисельного массива из 5 элементов
        int[] intArray5 = new int[5];

        //  заролнение массива сгенированными данными
        for (int i = 0; i < 5; i++) {
            int data = (int) (Math.random() * 20);
            intArray5[i] = data;

            //  Вывод созданного элемента массива в консоль для контроля
            System.out.println("значение " + intArray5[i] + " в " + getName());
        }

    }

    public void run() {
        intDataGenerator();
    }

    public static void main(String[] args) {

//  Создание  и закуск потоков

        for (int i = 0; i < 10; i++) {
            MultyThreads thread0 = new MultyThreads();
            thread0.start();
        }

    }
}
