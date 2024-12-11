package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
    POSICION,      VALOR_FIBONACCI
    0,          0
    1,          1
    2,          1
    3,          2
    4,          3
    """)
    @DisplayName("Comprueba que fibonacci devuelve 0 en 0")
    void testMain(int posicion, int valorFibonacci) {
        byte[] entradaPorTeclado = (posicion+"\n").getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String[] salidaCapturada = outputStream.toString().trim().split("\n"); 

        Assert.assertEquals("El número en la secuencia es: "+valorFibonacci, salidaCapturada[1]);
    }
}
