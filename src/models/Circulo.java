package src.models;

public class Circulo {
    
    private double radio;

    private Circulo(double radio) {
        this.radio = radio;
    }

    public static Circulo crear(double radio) {
        return new Circulo(radio);
    }

    public void calcularPerimetro(){
        System.out.printf("El perímetro del círculo es %.2f \n", 2 * Math.PI * this.radio);
    }

    public void calcularArea() {
        System.out.printf("El área del círculo es %.2f \n", Math.PI * (this.radio * this.radio)); 
    }
}
