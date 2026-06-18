package br.com.hamburgueria.pedidos;

import java.util.ArrayList;
import java.util.List;

public class PedidoMontado {

    private final String tipoLanche;
    private final List<String> adicionais;
    private final String observacao;
    private final String formaPagamento;

    public PedidoMontado(String tipoLanche, List<String> adicionais, String observacao, String formaPagamento) {
        this.tipoLanche = tipoLanche;
        this.adicionais = new ArrayList<>(adicionais);
        this.observacao = observacao;
        this.formaPagamento = formaPagamento;
    }

    public String getTipoLanche() {
        return tipoLanche;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    @Override
    public String toString() {
        return "PedidoMontado{tipo=" + tipoLanche + ", adicionais=" + adicionais
                + ", obs='" + observacao + "', pagamento=" + formaPagamento + "}";
    }
}
