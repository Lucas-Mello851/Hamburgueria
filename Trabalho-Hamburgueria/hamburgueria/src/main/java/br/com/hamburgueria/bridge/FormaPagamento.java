package br.com.hamburgueria.bridge;

public interface FormaPagamento {
    boolean processar(double valor);
    String getNome();
}
