package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.dominio.Pedido;

public class Cozinha {

    private CentralAtendimento mediator;
    private String pedidoAtual;
    private Pedido pedidoEmPreparo;
    private final CatalogoReceitas catalogoReceitas = new CatalogoReceitas();
    private java.util.List<String> ultimasEtapasPreparo;

    public void setMediator(CentralAtendimento mediator) {
        this.mediator = mediator;
    }

    public void receberPedido(String pedido) {
        this.pedidoAtual = pedido;
        mediator.notificar(this, "pedido_recebido");
    }

    public void receberPedido(Pedido pedido) {
        this.pedidoEmPreparo = pedido;
        this.pedidoAtual = pedido.getLanche().getDescricao();
        mediator.notificar(this, "pedido_recebido");
    }

    public void prepararPedido() {
        if (pedidoEmPreparo != null) {
            this.ultimasEtapasPreparo = catalogoReceitas.etapasDe(pedidoAtual);
            pedidoEmPreparo.marcarPronto();
        }
        mediator.notificar(this, "pedido_pronto");
    }

    public java.util.List<String> getUltimasEtapasPreparo() {
        return ultimasEtapasPreparo;
    }

    public CatalogoReceitas getCatalogoReceitas() {
        return catalogoReceitas;
    }

    public String getPedidoAtual() {
        return pedidoAtual;
    }

    public Pedido getPedidoEmPreparo() {
        return pedidoEmPreparo;
    }
}

