package Classes;

public class PagamentoCartao implements FormaPagamento {

    private final String tipo;

    public PagamentoCartao(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean processar(double valor) {
        System.out.printf("Pagamento no cartao %s: R$ %.2f processado.%n", tipo, valor);
        return true;
    }

    @Override
    public String getNome() { return "Cartao " + tipo; }
}
