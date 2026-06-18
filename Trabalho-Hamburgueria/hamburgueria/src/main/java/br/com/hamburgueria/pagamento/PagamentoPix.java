package br.com.hamburgueria.pagamento;

public class PagamentoPix implements FormaPagamento {

    @Override
    public boolean processar(double valor) {
        return true;
    }

    @Override
    public String getNome() {
        return "PIX";
    }
}
