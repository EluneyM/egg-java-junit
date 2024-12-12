package src;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = true;

        do {
            System.out.println("Ingrese un numbero y te dire si es primo");
            int number = sc.nextInt();
            check = esPrimos(number);

        } while (check);
        sc.close();
    }

    public static boolean esPrimos(Integer number) {
        if (number % 2 == 0) {
            if (number == 2) {
                return true;
            }
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}