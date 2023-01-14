package MathExamples;

import java.util.Scanner;

class MathThree{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println((a % 10) + (a / 10) % 10 + (a / 100)); // Сумма всех числе трехзначного числа
    }
}
