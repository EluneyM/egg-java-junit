package src.menu;

import java.util.Scanner;

import src.interfaces.OpcionMenu;
import src.models.Paralelogramo;

public class OpcionParalelogramo implements OpcionMenu{

    @Override
    public void ejecutar(Scanner sc) {
        System.out.println("Ingrese la base del paralelogramo:");
        double base = Double.valueOf(sc.nextLine());

        System.out.println("Ingrese altura del paralelogramo:");
        double altura = Double.valueOf(sc.nextLine());

        Paralelogramo paralelogramo = Paralelogramo.crear(base, altura);

        System.out.println("""
                    ¿Qué desea calcular?
                    1 - Perímetro del paralelogramo
                    2 - Área del paralelogramo
                """);

        int opcionCalculo = Integer.valueOf(sc.nextLine());

        if (opcionCalculo == 1) {
            paralelogramo.calcularPerimetro();
        }

        if (opcionCalculo == 2) {
            paralelogramo.calcularArea();
        }
    }
    
}
