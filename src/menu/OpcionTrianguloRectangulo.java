package src.menu;

import java.util.Scanner;

import src.interfaces.OpcionMenu;
import src.models.TrianguloRectangulo;

public class OpcionTrianguloRectangulo implements OpcionMenu {

    @Override
    public void ejecutar(Scanner sc) {
        System.out.println("Ingrese la base del tríangulo:");
        double base = Double.valueOf(sc.nextLine());

        System.out.println("Ingrese altura del tríangulo:");
        double altura = Double.valueOf(sc.nextLine());

        TrianguloRectangulo trianguloRectangulo = TrianguloRectangulo.crear(base, altura);

        System.out.println("""
                    ¿Qué desea calcular?
                    1 - Perímetro del tríangulo
                    2 - Área del tríangulo
                """);

        int opcionCalculo = Integer.valueOf(sc.nextLine());

        if (opcionCalculo == 1) {
            trianguloRectangulo.calcularPerimetro();
        }
        
        if (opcionCalculo == 2) {
            trianguloRectangulo.calcularArea();
        }
    }

}
