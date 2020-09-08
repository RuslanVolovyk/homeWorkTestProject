
// клас для функции

// Функция нахождения факториала через рекуасию
public class Factorial {

    public static long getNumber(int position){
        if (position <= 1)
            return 1;
        return  position * getNumber(position-1);
    }
}