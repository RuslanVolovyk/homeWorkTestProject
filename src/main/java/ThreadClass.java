public class ThreadClass extends Thread {

    //  синхронизированый метод который будет использоватся в 2 разных потоках
    public synchronized void printToConsole() {
        System.out.print("Hi ");
        System.out.print("I am  ");
        System.out.print("a synchronized  ");
        System.out.println("method.");
    }

    // оверрайдинг ран метода
    public void run() {
        printToConsole();
    }

    public static void main(String[] args) {

//  Создание потоков
        ThreadClass thread1 = new ThreadClass();
        ThreadClass thread2 = new ThreadClass();

//  запуск потоков
        thread1.start();
        thread2.start();
    }

}
