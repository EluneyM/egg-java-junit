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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Si la puntuación está entre 90 y 100, muestra 'A'")
    @ParameterizedTest
    @CsvSource({ "'90\n'", "'95\n'", "'100\n'" })
    void testMuestraA(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        Assert.assertEquals("A", salidaCapturada);
    }
}
