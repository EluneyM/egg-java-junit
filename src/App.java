package src;

import java.util.Scanner;

public class App {
    public static Scanner miScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el número menor del rango");
        int numMenor = miScanner.nextInt();
        System.out.println("Ingrese el número mayor del rango:");
        int numMayor = miScanner.nextInt();
        int numrandom = numeroAleatorio(numMayor, numMenor);
        adivinar(numrandom, numMayor, numMenor);

    }

    public static int numeroAleatorio(int max, int min) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void adivinar(int numrandom, int max, int min) {
        int numeroIngresadoUsuario;
        do {
            System.out.printf("Ingrese un número entre %d y %d\n", min, max);
            numeroIngresadoUsuario = miScanner.nextInt();
            if (numeroIngresadoUsuario > numrandom) {
                System.out.println("El número secreto es menor");
            } else if (numeroIngresadoUsuario < numrandom) {
                System.out.println("El número secreto es mayor");
            }
        } while (numeroIngresadoUsuario != numrandom);
        System.out.println("Encontraste el número! es: " + numrandom);

    }

}