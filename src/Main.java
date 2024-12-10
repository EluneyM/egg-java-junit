package src;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int numeroAleatorio = random.nextInt(355) + 1;
        
        System.out.println(numeroAleatorio);
    }
}