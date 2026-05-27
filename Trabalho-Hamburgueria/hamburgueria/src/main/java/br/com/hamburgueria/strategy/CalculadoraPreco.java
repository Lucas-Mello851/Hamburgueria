package br.com.hamburgueria.strategy;

public class CalculadoraPreco {

    private DescontoStrategy strategy;

    public CalculadoraPreco(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcularPrecoFinal(double precoOriginal) {
        double precoComDesconto = strategy.calcular(precoOriginal);
        return precoComDesconto;
    }

    public String getDescricaoDesconto() {
        String descricao = strategy.getDescricao();
        return descricao;
    }
}
