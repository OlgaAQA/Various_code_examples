import java.util.Scanner;

public class GameOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ttt = (int) (Math.random() * 10 + 1);
        System.out.println(ttt);
        int ggg = 0;
        System.out.println("Добро пожаловать в игру Тренировка Интуиции!!!");
        System.out.println("Отгадай какое число от 1 до 100 загаданно:");
        while (ggg != ttt) {
            ggg = sc.nextInt();
            System.out.println("Вы ввели:" + ggg + ".");
            if (ggg > ttt)
                System.out.println("Загаданное число меньше! Попробуй снова:");

            else if (ggg > ttt)
                System.out.println("Загаданное число больше! Попробуй снова:");
            else
                System.out.println(ggg + "Ты отгадал!!! Поздравляю! У тебя отличная интуиция!");
        }
    }

}
