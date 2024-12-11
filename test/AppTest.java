package test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import src.App;

public class AppTest {
    @RepeatedTest(25)
    void testNumeroAleatorio() {
        int numMenor = 13;
        int numMayor = 35;
        int numeroRandom = App.numeroAleatorio(numMayor, numMenor);
        System.out.println(" " + numeroRandom + " " + numMayor + " " + numMenor);
        assertTrue(numeroRandom >= numMenor && numeroRandom <= numMayor);
    }

    @RepeatedTest(1)

    void testAdivinar() {
        byte[] entradaPorTeclado = "15\n17\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        App.miScanner = new Scanner(System.in);

        App.adivinar(17, 35, 13);

        String salidaCapturada = outputStream.toString().trim();

        String esperado = "Ingrese un número entre 13 y 35\nEl número secreto es mayor\nIngrese un número entre 13 y 35\nEncontraste el número! es: 17";

        assertEquals(esperado, salidaCapturada);
    }

    private final PrintStream printStream = System.out;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }
}

