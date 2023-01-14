package MathExamples;

import java.util.Scanner;

class MathTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int t = sc.nextInt();
        int s = v * t;

        while (s > 109) {
            s = s - 109;
        }
        while (s < 0) {
            s = s + 109;
        }
        if (s == 109) {
            s = 0;
        }

        System.out.print(s);
    }
}
