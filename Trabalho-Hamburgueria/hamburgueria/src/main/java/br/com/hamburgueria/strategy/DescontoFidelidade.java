package br.com.hamburgueria.strategy;

public class DescontoFidelidade implements DescontoStrategy {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * 0.90;
    }

    @Override
    public String getDescricao() {
        return "Desconto fidelidade (10%)";
    }
}
