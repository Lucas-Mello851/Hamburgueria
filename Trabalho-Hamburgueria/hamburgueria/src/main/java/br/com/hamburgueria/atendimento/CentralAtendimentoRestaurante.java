package br.com.hamburgueria.atendimento;


import java.util.ArrayList;
import java.util.List;

public class CentralAtendimentoRestaurante implements CentralAtendimento {

    private static final String EVENTO_REGISTRADO = "pedido_registrado:";
    private static final String EVENTO_RECEBIDO = "pedido_recebido";
    private static final String EVENTO_PRONTO = "pedido_pronto";
    private static final String EVENTO_RETIRADO = "pedido_retirado";

    private Cozinha cozinha;
    private PostoCaixa caixa;
    private Entregador entregador;
    private List<String> eventosRegistrados = new ArrayList<>();
    private FilaDePedidos filaPedidos;

    public CentralAtendimentoRestaurante(Cozinha cozinha, PostoCaixa caixa, Entregador entregador) {
        this.cozinha = cozinha;
        this.caixa = caixa;
        this.entregador = entregador;
        cozinha.setMediator(this);
        caixa.setMediator(this);
        entregador.setMediator(this);
    }

    public void setFilaPedidos(FilaDePedidos filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void notificar(Object remetente, String evento) {
        eventosRegistrados.add(evento);

        if (evento.startsWith(EVENTO_REGISTRADO)) {
            String nomePedido = evento.split(":")[1];
            cozinha.receberPedido(nomePedido);
            if (filaPedidos != null) {
                filaPedidos.novoPedido(nomePedido);
            }
        } else if (evento.equals(EVENTO_RECEBIDO)) {
            cozinha.prepararPedido();
        } else if (evento.equals(EVENTO_PRONTO)) {
            entregador.buscarPedido(cozinha.getPedidoAtual());
            if (filaPedidos != null) {
                filaPedidos.pedidoPronto(cozinha.getPedidoAtual());
            }
        } else if (evento.equals(EVENTO_RETIRADO)) {
            caixa.confirmarEntrega();
        }
    }

    public List<String> getEventosRegistrados() {
        return eventosRegistrados;
    }
}
