package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/numeros.csv")
    @DisplayName("Probando varios números")
    void testEsPrimo(boolean check, int number) {
        Assertions.assertEquals(check, Main.esPrimo(number));
    }


    @Test
    void testConsole() {
        byte[] entradaPorTeclado = "22\n4\n6\n6\n2\n0\n".getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(entradaPorTeclado);
        System.setIn(in);
        Main.sc = new Scanner(System.in);

        Main.main(new String[1]);
        
        String salidaCapturada = outputStream.toString().trim();
        
        String resultadoEsperado = "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "No es primo." + System.lineSeparator() + "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "No es primo." + System.lineSeparator() + "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "No es primo." + System.lineSeparator() + "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "No es primo." + System.lineSeparator() + "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "Es primo." + System.lineSeparator() + "Introduce un número para verificar si es primo (0 para salir)" + System.lineSeparator() + "No es primo.";
                
        Assertions.assertEquals(resultadoEsperado, salidaCapturada);
        
        Assertions.assertEquals(salidaCapturada.compareTo(resultadoEsperado), 0);
    }
}
