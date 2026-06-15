package br.com.hamburgueria.adapter;

import br.com.hamburgueria.bridge.FormaPagamento;

public class MaquininhaAdapter implements FormaPagamento {

    private MaquininhaExterna maquininha;

    public MaquininhaAdapter(MaquininhaExterna maquininha) {
        this.maquininha = maquininha;
    }

    @Override
    public boolean processar(double valor) {
        double valorEmCentavos = valor * 100;
        String resultado = maquininha.cobrar(valorEmCentavos);
        boolean aprovado = "APROVADO".equals(resultado);
        if (aprovado) {
            System.out.println("Pagamento aprovado pela " + maquininha.getOperadora());
        } else {
            System.out.println("Pagamento recusado pela " + maquininha.getOperadora());
        }
        return aprovado;
    }

    @Override
    public String getNome() {
        return "Maquininha " + maquininha.getOperadora();
    }
}
