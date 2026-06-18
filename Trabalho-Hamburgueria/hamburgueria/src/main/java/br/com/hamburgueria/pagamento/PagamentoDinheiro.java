package br.com.hamburgueria.pagamento;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public boolean processar(double valor) {
        return true;
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }
}
