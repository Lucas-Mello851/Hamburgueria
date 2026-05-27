package br.com.hamburgueria.strategy;

public interface DescontoStrategy {
    double calcular(double precoOriginal);
    String getDescricao();
}
