package Homework;

import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Exercise3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("iIngresa cuantos numeros de la serie de Fibonacci quieres mostrar: ");
        int count = input.nextInt();

        IntFunction <Long> fibonacci = n->{
            if (n == 0) return 0L;
            if (n == 1) return 1L;
            long[] fib = new long[n+1];

            fib[0] = 0L;
            fib[1] = 1L;
            IntStream.range(2,n+1).forEach(i ->fib[i] = fib[i-1]+fib[i-2]);
            return fib[n];
        };
        IntStream.range(0,count).forEach(i -> System.out.println("Numero: "+(i+1)+"  de la serie de Fibonacci: "+fibonacci.apply(i)));
    }
}