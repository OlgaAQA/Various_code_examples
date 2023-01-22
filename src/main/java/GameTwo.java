import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain = "";
        do {
            System.out.println("Добро пожаловать в игру. Тибетское предсказание!");
            System.out.println("Напиши одно слово, которым вы можешь описать слово СОБАКА:");
            String animal0 = sc.next();
            System.out.println("Напиши одно слово, которым вы можешь описать слово БЫК:");
            String animal1 = sc.next();
            System.out.println("Напиши одно слово, которым вы можешь описать слово ОГОНЬ:");
            String animal2 = sc.next();
            System.out.println("Напиши одно слово, которым вы можешь описать слово ЗЕМЛЯ:");
            String animal3 = sc.next();
            System.out.println("Напиши одно слово, которым вы можешь описать слово РЕКА:");
            String animal4 = sc.next();
            System.out.println("Предсказание предсказывается!");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println("Монахи думают");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println(".............................");
            System.out.println("Твой ответ готов!");
            System.out.println("..." + animal0 + "" + " подразумевает вашу собственную личность.");
            System.out.println("..." + animal1 + "" + " подразумевает личность вашего партнера.");
            System.out.println("..." + animal2 + "" + " подразумевает личность ваших врагов.");
            System.out.println("..." + animal3 + "" + " подразумевает вашу работу.");
            System.out.println("..." + animal4 + "" + " подразумевает вашу повседневную жизнь.");
            System.out.println("Хочешь сыграть снова? Введи да или нет:");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("да"));
        System.out.println("Спасибо за игру!");
        sc.close();
    }

}
