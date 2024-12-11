package src.menu;

import java.util.Scanner;

import src.interfaces.OpcionMenu;

public class OpcionInvalida implements OpcionMenu {

    @Override
    public void ejecutar(Scanner sc) {
        System.out.println("Opción no válida.");
    }

}
