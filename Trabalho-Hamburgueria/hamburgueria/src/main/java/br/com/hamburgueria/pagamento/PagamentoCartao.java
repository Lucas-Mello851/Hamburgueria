package br.com.hamburgueria.pagamento;

public class PagamentoCartao implements FormaPagamento {

    private final String tipo;

    public PagamentoCartao(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean processar(double valor) {
        return true;
    }

    @Override
    public String getNome() {
        return "Cartao " + tipo;
    }
}
