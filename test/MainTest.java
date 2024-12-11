package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import src.Main;

public class MainTest {
    private final PrintStream printStream = System.out;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public static final String MENSAJE_MENU_1 = """
            ¿Qué figura geométrica desea utilizar?
            1 - Círculo
            2 - Tríangulo Reactángulo
            3 - Paralelogramo
           
            """;

    public static final String MENSAJE_MENU_CIRCULO = """
            Ingrese radio del circulo
                ¿Qué desea calcular?
                1 - Perímetro del círculo
                2 - Área del círculo

            """;

    public static final String MENSAJE_MENU_TRIANGULO_RECTANGULO = """
            Ingrese la base del tríangulo: 
            Ingrese altura del tríangulo:
                ¿Qué desea calcular?
                1 - Perímetro del tríangulo
                2 - Área del tríangulo

            """;

    public static final String MENSAJE_MENU_PARALELOGRAMO = """
                Ingrese la base del paralelogramo: 
                Ingrese altura del paralelogramo:
                    ¿Qué desea calcular?
                    1 - Perímetro del paralelogramo
                    2 - Área del paralelogramo
    
                """;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown(){
        System.setOut(printStream);
    }

    @Test
    @DisplayName("Debería calcular el perímetro del círculo")
    void testCalcularPerimetroDelCirculo() {
        byte[] entradaPorTeclado = "1\n10\n1\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_CIRCULO + """
            El perímetro del círculo es 62.83""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }

    @Test
    @DisplayName("Debería calcular el área del círculo")
    void testCalcularAreaDelCirculo() {
        byte[] entradaPorTeclado = "1\n10\n2\n".getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_CIRCULO + """
            El área del círculo es 314.16""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }

    @Test
    @DisplayName("Debería calcular el perímetro del tríangulo rectángulo")
    void testCalcularPerimetroDelTrianguloRectangulo() {
        byte[] entradaPorTeclado = "2\n10\n20\n1\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_TRIANGULO_RECTANGULO + """
            El perímetro del tríangulo es 52.36""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }

    @Test
    @DisplayName("Debería calcular el área del tríangulo rectángulo")
    void testCalcularAreaDelTrianguloRectangulo() {
        byte[] entradaPorTeclado = "2\n10\n20\n2\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_TRIANGULO_RECTANGULO + """
            El área del tríangulo es 100.00""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }

    @Test
    @DisplayName("Debería calcular el perímetro del paralelogramo")
    void testCalcularPerimetroDelParalelogramo() {
        byte[] entradaPorTeclado = "3\n10\n20\n1\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_PARALELOGRAMO + """
            El perímetro del paralelogramo es 60.00""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }

    @Test
    @DisplayName("Debería calcular el área del paralelogramo")
    void testCalcularAreaDelParalelogramo() {
        byte[] entradaPorTeclado = "3\n10\n20\n2\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String resultadoEsperado = MENSAJE_MENU_1 + MENSAJE_MENU_PARALELOGRAMO + """
            El área del paralelogramo es 200.00""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }
}
