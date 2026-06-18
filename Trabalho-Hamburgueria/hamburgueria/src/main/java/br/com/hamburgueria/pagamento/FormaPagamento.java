package br.com.hamburgueria.pagamento;

public interface FormaPagamento {
    boolean processar(double valor);
    String getNome();
}
