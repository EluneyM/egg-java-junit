package src.models;

public class Circulo extends FiguraGeometrica{
    
    private double radio;

    private Circulo(double radio) {
        this.radio = radio;
    }

    public static Circulo crear(double radio) {
        return new Circulo(radio);
    }

    @Override
    public void calcularPerimetro(){
        System.out.printf("El perímetro del círculo es %.2f \n", 2 * Math.PI * this.radio);
    }

    @Override
    public void calcularArea() {
        System.out.printf("El área del círculo es %.2f \n", Math.PI * (this.radio * this.radio)); 
    }
}
