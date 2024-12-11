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

        String resultadoEsperado = """
            ¿Qué figura geométrica desea utilizar?
            1 - Círculo
            2 - Tríangulo
            3 - Paralelogramo

            Ingrese radio del circulo
                ¿Qué desea calcular?
                1 - Perímetro del círculo
                2 - Área del círculo

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

        String resultadoEsperado = """
            ¿Qué figura geométrica desea utilizar?
            1 - Círculo
            2 - Tríangulo
            3 - Paralelogramo

            Ingrese radio del circulo
                ¿Qué desea calcular?
                1 - Perímetro del círculo
                2 - Área del círculo

            El área del círculo es 314.16""";

        Assert.assertEquals(resultadoEsperado, salidaCapturada);
    }
}
