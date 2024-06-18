package Homework;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("ingresa el primer numero: ");
        int n1 = input.nextInt();
        System.out.println("ingresa el segundo numero: ");
        int n2 = input.nextInt();
        System.out.println("ingresa el tercer numero: ");
        int n3 = input.nextInt();

        System.out.println("Los numeros ingresados son :"+n1+", "+n2+" y "+n3);
        BiFunction<Integer,Integer, Integer> maxFunction = (a,b) -> a > b ? a:b;
        int max = maxFunction.apply(maxFunction.apply(n1,n2),n3);
        System.out.println("El numero mas grande es: "+ max);

    }
}