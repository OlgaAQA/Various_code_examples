import java.util.Scanner;

public class MathOne {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextInt();
        float b = sc.nextInt();
        float c = sc.nextInt();
        float result = (a + b - 3) * c / 2 % 10; // Показывает последнее число вычисленного результата
        //float result = a / b ;
        System.out.println(result);
    }
}
