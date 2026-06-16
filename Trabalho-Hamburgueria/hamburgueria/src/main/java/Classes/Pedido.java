package Classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    protected String tipoLanche;
    protected List<String> adicionais;
    protected String observacao;
    protected String formaPagamentoDescricao;
    protected FormaPagamento formaPagamento;
    protected double total;

    public Pedido(String tipoLanche, List<String> adicionais, String observacao, String formaPagamentoDescricao) {
        this.tipoLanche = tipoLanche;
        this.adicionais = new ArrayList<>(adicionais);
        this.observacao = observacao;
        this.formaPagamentoDescricao = formaPagamentoDescricao;
    }

    protected Pedido(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        this.adicionais = new ArrayList<>();
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void finalizar() {
        System.out.println("Pedido finalizado: " + tipoLanche + " " + adicionais);
        if (formaPagamento != null) {
            formaPagamento.processar(total);
        }
    }

    public double getTotal() { return total; }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return new ArrayList<>(adicionais); }
    public String getObservacao() { return observacao; }
    public String getFormaPagamentoDescricao() { return formaPagamentoDescricao; }
}
