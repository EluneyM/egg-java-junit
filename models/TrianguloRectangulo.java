package models;

public class TrianguloRectangulo extends FiguraGeometrica {
    
    private double base;
    private double altura;
    private double hipotenusa;

    private TrianguloRectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
        this.hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    public static TrianguloRectangulo crear(double base, double altura) {
        return new TrianguloRectangulo(base, altura);
    }

    @Override
    public void calcularPerimetro() {
        System.out.printf("El perímetro del tríangulo es %.2f", this.base + this.altura + this.hipotenusa);
    }

    @Override
    public void calcularArea() {
        System.out.printf("El área del tríangulo es %.2f", (this.base * this.altura) / 2);
    }

    
}
