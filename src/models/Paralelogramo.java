package src.models;

public class Paralelogramo extends FiguraGeometrica {

    private double base;
    private double altura;

    private Paralelogramo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public static Paralelogramo crear(double base, double altura) {
        return new Paralelogramo(base, altura);
    }

    @Override
    public void calcularPerimetro() {
        System.out.printf("El perímetro del paralelogramo es %.2f", 2 * (this.base + this.altura));
    }

    @Override
    public void calcularArea() {
        System.out.printf("El área del paralelogramo es %.2f", this.base * this.altura);
    }
    
}
