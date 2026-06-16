package Classes;

public interface FormaPagamento {
    boolean processar(double valor);
    String getNome();
}
