package Classes;

public class DescontoPromocao implements DescontoStrategy {

    private final double percentual;

    public DescontoPromocao(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * (1 - percentual / 100);
    }

    @Override
    public String getDescricao() {
        return "Promocao (" + percentual + "% off)";
    }
}
