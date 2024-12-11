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

    @DisplayName("Prueba todos los casos de errores de contraseña")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/passwords.csv")
    void testIngresoDePasswords(String password, String mensaje) {

        ByteArrayInputStream in = new ByteArrayInputStream(password.getBytes());
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);

        String salidaCapturada = outputStream.toString().trim();

        Assert.assertEquals(mensaje, salidaCapturada);
    }
}
