package ExamplesJava;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una frase: ");
        String original = input.nextLine();
        String frase = original.toLowerCase().replaceAll("\\s+","");
        String reversa = new StringBuilder(frase).reverse().toString();

        if (frase.equals(reversa)){
            System.out.println("\""+original+"\" es un palindromo");
        }else{
            System.out.println("\""+original+"\" no es un palindromo");
        }
    }
}
