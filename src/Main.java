package src;

import java.util.Scanner;

import src.menu.Menu;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu(sc);
        menu.iniciar();

        sc.close();
    }
}