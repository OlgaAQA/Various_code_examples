import java.util.Scanner;

public class GameOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ttt = (int) (Math.random() * 100 + 1);
        System.out.println(ttt);
        int guess = 0;
        System.out.println("Добро пожаловать в игру Тренировка Интуиции!!!");
        System.out.println("Отгадай какое число от 1 до 100 загаданно:");
        guess = sc.nextInt();
        System.out.println("Вы ввели:" + guess +".");
    }

}
