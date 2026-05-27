package br.com.hamburgueria.mediator;

public class RestauranteConcreteMediator implements RestauranteMediator {

    private Cozinha cozinha;
    private Caixa caixa;
    private Entregador entregador;

    public RestauranteConcreteMediator(Cozinha cozinha, Caixa caixa, Entregador entregador) {
        this.cozinha = cozinha;
        this.caixa = caixa;
        this.entregador = entregador;
        cozinha.setMediator(this);
        caixa.setMediator(this);
        entregador.setMediator(this);
    }

    @Override
    public void notificar(Object remetente, String evento) {
        if (evento.startsWith("pedido_registrado:")) {
            String[] partes = evento.split(":");
            String nomePedido = partes[1];
            cozinha.receberPedido(nomePedido);
        }

        if (evento.equals("pedido_recebido")) {
            cozinha.prepararPedido();
        }

        if (evento.equals("pedido_pronto")) {
            String pedidoAtual = cozinha.getPedidoAtual();
            entregador.buscarPedido(pedidoAtual);
        }

        if (evento.equals("pedido_retirado")) {
            caixa.confirmarEntrega();
        }
    }
}
