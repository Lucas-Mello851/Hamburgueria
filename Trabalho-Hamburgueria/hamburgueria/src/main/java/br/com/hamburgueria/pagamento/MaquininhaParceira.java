package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;


public class MaquininhaParceira implements FormaPagamento {

    private static final String RETORNO_APROVADO = "APROVADO";

    private MaquininhaExterna maquininha;

    public MaquininhaParceira(MaquininhaExterna maquininha) {
        this.maquininha = maquininha;
    }

    @Override
    public boolean processar(double valor) {
        double valorEmCentavos = valor * Precos.CENTAVOS_POR_REAL;
        String resultado = maquininha.cobrar(valorEmCentavos);
        return RETORNO_APROVADO.equals(resultado);
    }

    @Override
    public String getNome() {
        return "Maquininha " + maquininha.getOperadora();
    }
}
