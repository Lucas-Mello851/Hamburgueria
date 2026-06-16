package Classes;

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

    public PedidoBuilder adicionar(String adicional) {
        if (!CatalogoAdicionais.existe(adicional)) {
            throw new IllegalArgumentException("Adicional desconhecido: " + adicional);
        }
        adicionais.add(adicional);
        return this;
    }

    public PedidoBuilder adicionarQueijo()        { return adicionar(CatalogoAdicionais.QUEIJO); }
    public PedidoBuilder adicionarBacon()         { return adicionar(CatalogoAdicionais.BACON); }
    public PedidoBuilder adicionarAlface()        { return adicionar(CatalogoAdicionais.ALFACE); }
    public PedidoBuilder adicionarTomate()        { return adicionar(CatalogoAdicionais.TOMATE); }
    public PedidoBuilder adicionarMolhoEspecial() { return adicionar(CatalogoAdicionais.MOLHO); }

    public PedidoBuilder setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public PedidoBuilder setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public PedidoBuilder aPartirDoTexto(ContextoPedidoTexto contexto) {
        setTipoLanche(contexto.getTipoLanche());
        for (String adicional : contexto.getAdicionais()) {
            adicionar(adicional);
        }
        if (!contexto.getRemocoes().isEmpty()) {
            setObservacao("Remover: " + String.join(", ", contexto.getRemocoes()));
        }
        return this;
    }

    public Pedido build() {
        if (tipoLanche == null || tipoLanche.equals("")) {
            throw new IllegalStateException("Tipo de lanche e obrigatorio.");
        }
        return new Pedido(tipoLanche, adicionais, observacao, formaPagamento);
    }
}
