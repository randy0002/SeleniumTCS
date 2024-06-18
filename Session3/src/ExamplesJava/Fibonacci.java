package ExamplesJava;
import java.util.Scanner;
public class Fibonacci{
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("Ingresa cuantos numeros de la serie de Fibonacci quieres mostrar? ");
 int count= input.nextInt();
 long[] fibonaciSeries = new long[count];
 for(int i= 0;i < count; i++){
     if(i==0 ||i == 1){
         fibonaciSeries[i] = i;
}else {
         fibonaciSeries[i] = fibonaciSeries[i - 1] + fibonaciSeries[i - 2];
     }
    System. out.println( "Numero "+(1+1)+" de la serie de Fibonacci: "+fibonaciSeries[i]);
 }
}
}