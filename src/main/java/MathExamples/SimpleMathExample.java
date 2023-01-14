package MathExamples;

import java.util.Scanner;

public class SimpleMathExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите 4 различных числа, подтверждая нажатием Enter");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
//        float result = (a + b - 3) * c / 2 % 10; // Показывает последнее число вычисленного результата
//        //float result = a / b ;
//        System.out.println((a % 10) + (a / 10) % 10 + (a / 100)); // Сумма всех числе трехзначного числа
//        System.out.println(result);

        System.out.println("Задача №1.Выводим результат вычислений с текстовым сообщением:");
        System.out.println("Введенное число:" + " " + d + ".");
        System.out.println("Следующее число:" + " " + d + " " + "is" + " " + (d + 1) + ".");
        System.out.println("Число до:" + " " + d + " " + "is" + " " + (d - 1) + ".");

        System.out.println("---------------------");

        System.out.println("Задача №2.Показывает последнее число вычисленного результата:");
        System.out.println("Введенные числа:" + " " + a + "," + b + "," + c + ".");
        int result = (a + b) * c / 2 % 10;
        int result1 = (a + b) * c / 2;
        System.out.println("Вычисленный результат:" + result1);
        System.out.println("Его последнее число:" + result);

        System.out.println("---------------------");
        // !!!!Доработать задачу, сделать цикл для неверного числа
        System.out.println("Задача №3.Сумма всех чисел трехзначного числа:");
        System.out.println("Пожалуйста введите любое трехзначное число, подтверждая нажатием Enter");
        int e = sc.nextInt();
        if (e >= 100) {
            System.out.println("Сумма всех чисел трехзначного числа:");
            System.out.println((e % 10) + (e / 10) % 10 + (e / 100));
        }
        else
        {
            System.out.println("Вы ввели не трехзначное число, пожалуйста попробуйте снова.");
        }


    }
}
