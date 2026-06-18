package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;


public class DescontoEstudante implements PoliticaDesconto {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * Precos.FATOR_DESCONTO_ESTUDANTE;
    }

    @Override
    public String getDescricao() {
        return "Desconto estudante (15%)";
    }
}
