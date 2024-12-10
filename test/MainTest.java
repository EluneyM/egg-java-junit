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
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import src.Main;

public class MainTest {
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

    @DisplayName("Si la puntuación está entre 90 y 100, muestra 'A'")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/notesA.csv")
    void testMuestraA(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra A";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Si la puntuación está entre 80 y 90, muestra 'B'")
    @ParameterizedTest
    @CsvSource({ "'80\n'", "'85\n'", "'89\n'" })
    void testMuestraB(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra B";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Si la puntuación está entre 80 y 90, muestra 'C'")
    @ParameterizedTest
    @CsvSource({ "'70\n'", "'75\n'", "'79\n'" })
    void testMuestraC(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra C";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Si la puntuación está entre 80 y 90, muestra 'B'")
    @ParameterizedTest
    @CsvSource({ "'60\n'", "'65\n'", "'69\n'" })
    void testMuestraD(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra D";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Si la puntuación está entre 80 y 90, muestra 'B'")
    @ParameterizedTest
    @CsvSource({ "'40\n'", "'1\n'", "'59\n'" })
    void testMuestraF(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra F";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Si la puntuación está entre 80 y 90, muestra 'B'")
    @ParameterizedTest
    @CsvSource({ "'101\n'", "'-1\n'", "'-100\n'" })
    void testMuestraError(String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim()
                + " corresponde a la letra : Error - El número ingresado está fuera de rango válido.";

        Assert.assertEquals(result, salidaCapturada);
    }

    @DisplayName("Prueba completa'")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/notes.csv")
    void testMuestra(String respuesta, String nota) {

        ByteArrayInputStream in = new ByteArrayInputStream(nota.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        String result = "Ingrese una puntuación para calificar\n" + //
                "La clasificación correspondiente a la puntuación " + nota.trim() + " corresponde a la letra "
                + respuesta;

        Assert.assertEquals(result, salidaCapturada);
    }

}
