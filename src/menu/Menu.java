package src.menu;

import java.util.Scanner;

import src.interfaces.OpcionMenu;

public class Menu {
    private Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

    public void mostrarMenu() {
        System.out.println("""
                ¿Qué figura geométrica desea utilizar?
                1 - Círculo
                2 - Tríangulo Reactángulo
                3 - Paralelogramo
                """);
    }

    public OpcionMenu seleccionarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                return new OpcionCirculo();
            case 2:
                return new OpcionTrianguloRectangulo();
            case 3:
                return new OpcionParalelogramo();
            default:
                System.out.println("Opción no válida.");
                return null;
        }
    }

    public void iniciar() {
        mostrarMenu();
        int opcion = Integer.valueOf(sc.nextLine());
        OpcionMenu opcionSeleccionada = seleccionarOpcion(opcion);
        if (opcionSeleccionada != null) {
            opcionSeleccionada.ejecutar(sc);
        }
    }
}
