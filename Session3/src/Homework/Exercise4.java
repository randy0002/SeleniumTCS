package Homework;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Exercise4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce tres números:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println("El número más grande entre " + num1 + ", " + num2 + " y " + num3 + " es: " + findGreatest(num1, num2, num3));

        System.out.println("Introduce cuatro números:");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();
        int num4 = scanner.nextInt();
        System.out.println("El número más grande entre " + num1 + ", " + num2 + ", " + num3 + " y " + num4 + " es: " + findGreatest(num1, num2, num3, num4));
    }

    // Método para encontrar el número más grande
    public static int findGreatest(int num1, int num2, int num3) {
        IntBinaryOperator findMax = (a, b) -> a > b ? a : b;
        return findMax.applyAsInt(findMax.applyAsInt(num1, num2), num3);
    }

    public static int findGreatest(int num1, int num2, int num3, int num4) {
        IntBinaryOperator findMax = (a, b) -> a > b ? a : b;
        return findMax.applyAsInt(findMax.applyAsInt(findMax.applyAsInt(num1, num2), num3), num4);
    }
}