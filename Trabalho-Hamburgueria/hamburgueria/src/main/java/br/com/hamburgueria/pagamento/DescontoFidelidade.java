package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;


public class DescontoFidelidade implements PoliticaDesconto {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * Precos.FATOR_DESCONTO_FIDELIDADE;
    }

    @Override
    public String getDescricao() {
        return "Desconto fidelidade (10%)";
    }
}
