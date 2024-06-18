package ExamplesJava;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        System.out.println("Ingresa un numero: ");
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();
        if(num >= 10){
            System.out.println("El numero  ingresado es mayor a diez y es el siguiente: "+num);
        }else{
            System.out.println("El numero  ingresado es menor diez y es el siguiente: "+num);
        }
    }
}
