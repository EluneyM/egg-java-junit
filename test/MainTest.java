package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    @DisplayName("Comprueba que main devulve el saludo")
    void testMain() {
        Main.main(new String[1]);
        // Capturar la salida como una cadena
        Integer salidaCapturada = Integer.valueOf(outputStream.toString().trim()); // Usar trim() para eliminar saltos de línea al final

        boolean numeroEntre1Y355 = (salidaCapturada >= 1 || salidaCapturada <= 355);
        // Verificar que la salida sea la esperada
        Assert.assertTrue(numeroEntre1Y355);
    }
}
