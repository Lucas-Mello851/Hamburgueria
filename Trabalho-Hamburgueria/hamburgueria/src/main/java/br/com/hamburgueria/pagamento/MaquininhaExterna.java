package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;


public class MaquininhaExterna {

    private static final String RETORNO_APROVADO = "APROVADO";
    private static final String RETORNO_RECUSADO = "RECUSADO";

    private String operadora;

    public MaquininhaExterna(String operadora) {
        this.operadora = operadora;
    }

    public String cobrar(double valorEmCentavos) {
        if (valorEmCentavos > Precos.LIMITE_COBRANCA_MAQUININHA_CENTAVOS) {
            return RETORNO_RECUSADO;
        }
        return RETORNO_APROVADO;
    }

    public String getOperadora() {
        return operadora;
    }
}
