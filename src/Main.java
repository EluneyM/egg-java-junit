package src;

import java.util.Scanner;

import src.models.PasswordValidator;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator(sc.nextLine());
        sc.close();

        passwordValidator
                .minimoCaracteres(8)
                .incluirMinusculaMayuscula()
                .incluirNumero()
                .incluirCaracterEspecial();

        passwordValidator.mostrarErrores();
    }
}