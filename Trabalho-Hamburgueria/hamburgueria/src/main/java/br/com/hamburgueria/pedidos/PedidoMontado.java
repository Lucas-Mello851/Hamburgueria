package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pagamento.FormaPagamento;

import java.util.ArrayList;
import java.util.List;

public class PedidoMontado {

    private final String tipoLanche;
    private final List<String> adicionais;
    private final String observacao;
    private final String formaPagamento;
    private final FormaPagamento formaPagamentoReal;

    public PedidoMontado(String tipoLanche, List<String> adicionais, String observacao, String formaPagamento) {
        this(tipoLanche, adicionais, observacao, formaPagamento, null);
    }

    public PedidoMontado(String tipoLanche, List<String> adicionais, String observacao,
                         String formaPagamento, FormaPagamento formaPagamentoReal) {
        this.tipoLanche = tipoLanche;
        this.adicionais = new ArrayList<>(adicionais);
        this.observacao = observacao;
        this.formaPagamento = formaPagamento;
        this.formaPagamentoReal = formaPagamentoReal;
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

    public FormaPagamento getFormaPagamentoReal() {
        return formaPagamentoReal;
    }

    public boolean cobrar(double valor) {
        if (formaPagamentoReal == null) {
            return false;
        }
        return formaPagamentoReal.processar(valor);
    }

    @Override
    public String toString() {
        return "PedidoMontado{tipo=" + tipoLanche + ", adicionais=" + adicionais
                + ", obs='" + observacao + "', pagamento=" + formaPagamento + "}";
    }
}

