package src.menu;

import java.util.Scanner;

import src.interfaces.OpcionMenu;
import src.models.Circulo;

public class OpcionCirculo implements OpcionMenu {

    @Override
    public void ejecutar(Scanner sc) {
        System.out.println("Ingrese radio del circulo");
        double radio = Double.valueOf(sc.nextLine());

        Circulo circulo = Circulo.crear(radio);

        System.out.println("""
                    ¿Qué desea calcular?
                    1 - Perímetro del círculo
                    2 - Área del círculo
                """);

        int opcionCalculo = Integer.valueOf(sc.nextLine());

        if (opcionCalculo == 1) {
            circulo.calcularPerimetro();
        } else {
            circulo.calcularArea();
        }
    }

}
