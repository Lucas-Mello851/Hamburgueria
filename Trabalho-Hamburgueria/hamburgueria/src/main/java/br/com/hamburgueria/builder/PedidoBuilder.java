package br.com.hamburgueria.builder;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {

    private String tipoLanche;
    private List<String> adicionais;
    private String observacao;
    private String formaPagamento;

    public PedidoBuilder() {
        adicionais = new ArrayList<>();
        observacao = "";
        formaPagamento = "Dinheiro";
    }

    public PedidoBuilder setTipoLanche(String tipo) {
        this.tipoLanche = tipo;
        return this;
    }

    public PedidoBuilder adicionarQueijo() {
        adicionais.add("Queijo Cheddar");
        return this;
    }

    public PedidoBuilder adicionarBacon() {
        adicionais.add("Bacon Crocante");
        return this;
    }

    public PedidoBuilder adicionarAlface() {
        adicionais.add("Alface");
        return this;
    }

    public PedidoBuilder adicionarTomate() {
        adicionais.add("Tomate");
        return this;
    }

    public PedidoBuilder adicionarMolhoEspecial() {
        adicionais.add("Molho Especial");
        return this;
    }

    public PedidoBuilder setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public PedidoBuilder setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public Pedido build() {
        if (tipoLanche == null || tipoLanche.equals("")) {
            throw new IllegalStateException("Tipo de lanche e obrigatorio.");
        }
        Pedido pedido = new Pedido(tipoLanche, adicionais, observacao, formaPagamento);
        return pedido;
    }
}
