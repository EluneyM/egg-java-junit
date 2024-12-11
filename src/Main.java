package src;

import java.util.Scanner;

import models.Circulo;
import models.TrianguloRectangulo;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                ¿Qué figura geométrica desea utilizar?
                1 - Círculo
                2 - Tríangulo Reactángulo
                3 - Paralelogramo
                """);

        int opcionFigura = Integer.valueOf(sc.nextLine());

        if (opcionFigura == 1) {
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
       
        if (opcionFigura == 2) {
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
            } else {
                trianguloRectangulo.calcularArea();
            }
        }

        sc.close();
    }
}