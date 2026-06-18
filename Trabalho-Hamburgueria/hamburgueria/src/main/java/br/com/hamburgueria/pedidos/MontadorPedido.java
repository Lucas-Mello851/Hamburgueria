package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.ingredientes.Molho;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;


import java.util.ArrayList;
import java.util.List;

public class MontadorPedido {

    private String tipoLanche;
    private List<String> adicionais;
    private String observacao;
    private String formaPagamento;

    public MontadorPedido() {
        adicionais = new ArrayList<>();
        observacao = "";
        formaPagamento = "Dinheiro";
    }

    public MontadorPedido setTipoLanche(String tipo) {
        this.tipoLanche = tipo;
        return this;
    }

    public MontadorPedido adicionarQueijo() {
        adicionais.add("Queijo Cheddar");
        return this;
    }

    public MontadorPedido adicionarBacon() {
        adicionais.add("Bacon Crocante");
        return this;
    }

    public MontadorPedido adicionarAlface() {
        adicionais.add("Alface");
        return this;
    }

    public MontadorPedido adicionarTomate() {
        adicionais.add("Tomate");
        return this;
    }

    public MontadorPedido adicionarMolhoEspecial() {
        adicionais.add("Molho Especial");
        return this;
    }

    public MontadorPedido setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public MontadorPedido setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public PedidoMontado build() {
        if (tipoLanche == null || tipoLanche.equals("")) {
            throw new IllegalStateException("Tipo de lanche e obrigatorio.");
        }
        PedidoMontado pedido = new PedidoMontado(tipoLanche, adicionais, observacao, formaPagamento);
        return pedido;
    }
}
