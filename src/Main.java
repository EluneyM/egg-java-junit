package src;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Scanner scanner = sc) {
            int num;
            boolean esPrimo;
      
            do {
              esPrimo = true;
              System.out.println("Introduce un número para verificar si es primo (0 para salir)");
              num = Integer.valueOf(scanner.nextLine());
      
              if (esPrimo(num) && num > 1) {
                System.out.println("Es primo.");
              } else {
                System.out.println("No es primo.");
              }
      
            } while (!esPrimo || num != 0);
      
          } catch (Exception e) {
            System.out.println(e);
          }

        sc.close();
    }

    public static boolean esPrimo(Integer number) {
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