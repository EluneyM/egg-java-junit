package src;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Scanner scanner = sc) {
            System.out.println("Indica una posición para encontrar el número: ");
            int num = scanner.nextInt();

            System.out.println("El número en la secuencia es: " + fibonacciRecursivo(num));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static int fibonacciRecursivo(int num) {
        int numSecuencia;
        if (num < 2) {
            if (num == 0) {
                numSecuencia = 0;
            } else {
                numSecuencia = 1;
            }
            return numSecuencia;
        } else {
            numSecuencia = fibonacciRecursivo(num - 1) + fibonacciRecursivo(num - 2);
            return numSecuencia;
        }

    }
}