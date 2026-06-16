package Classes;

public class CalculadoraPreco {

    private DescontoStrategy strategy;

    public CalculadoraPreco(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public DescontoStrategy getStrategy() {
        return strategy;
    }

    public double calcularPrecoFinal(double precoOriginal) {
        return strategy.calcular(precoOriginal);
    }

    public String getDescricaoDesconto() {
        return strategy.getDescricao();
    }
}
