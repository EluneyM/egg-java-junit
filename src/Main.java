package src;

import java.util.Scanner;

import models.Circulo;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                ¿Qué figura geométrica desea utilizar?
                1 - Círculo
                2 - Tríangulo
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
       

        sc.close();
    }
}