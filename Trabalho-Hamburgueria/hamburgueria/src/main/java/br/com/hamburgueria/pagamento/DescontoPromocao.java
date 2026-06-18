package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;


public class DescontoPromocao implements PoliticaDesconto {

    private final double percentual;

    public DescontoPromocao(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * (1 - percentual / Precos.PERCENTUAL_TOTAL);
    }

    @Override
    public String getDescricao() {
        return "Promocao (" + percentual + "% off)";
    }
}
