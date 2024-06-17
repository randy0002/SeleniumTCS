package Homework;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("ingresa la primera palabra: ");
        String word1 = input.next();

        System.out.println("ingresa la segunda palabra: ");
        String word2 = input.next();

        System.out.println("La nueva palabra es: " + word1 + word2);
    }
}