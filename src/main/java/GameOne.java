import java.util.Scanner;

public class GameOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain = "";
        do {
            int ttt = (int) (Math.random() * 100 + 1);
            System.out.println(ttt);
            int ggg = 0;
            System.out.println("Добро пожаловать в игру Тренировка Интуиции!!!");
            System.out.println("Отгадай какое число от 1 до 100 загаданно:");
            while (ggg != ttt) {
                ggg = sc.nextInt();
                System.out.println("Вы ввели:" + ggg + ".");
                if (ggg > ttt)
                    System.out.println("Загаданное число меньше! Попробуй снова:");

                else if (ggg < ttt)
                    System.out.println("Загаданное число больше! Попробуй снова:");
                else
                    System.out.println("Ты отгадал!!! Поздравляю! У тебя отличная интуиция!");
            }
            System.out.println("Хочешь сыграть снова? Введи да или нет:");
            playAgain = sc.next();
        } while (playAgain.equalsIgnoreCase("да"));
        }

}
