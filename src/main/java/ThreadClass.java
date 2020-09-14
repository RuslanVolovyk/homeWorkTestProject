public class ThreadClass extends Thread {

    //  синхронизированый метод который будет использоватся в 2 разных потоках
    public synchronized void printToConsole() {
        System.out.print("Hi ");
        System.out.print("I am  ");
        System.out.print("a synchronized  ");
        System.out.println("method in " + getName());
    }

    // оверрайдинг ран метода
    public void run() {
        printToConsole();
    }

    public static void main(String[] args) {

//  Создание потоков
        ThreadClass thread0 = new ThreadClass();
        ThreadClass thread1 = new ThreadClass();

//  запуск потоков
        thread0.start();
        thread1.start();
    }

}
