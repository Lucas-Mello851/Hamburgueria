package Classes;

import Classes.Pedido;
import Classes.PedidoBuilder;
import Classes.ContextoPedido;

public class ComandoRegistrarPedido implements Comando {

    private String tipoLanche;
    private ContextoPedido contextoPedido;
    private Pedido pedidoRegistrado;

    public ComandoRegistrarPedido(String tipoLanche, ContextoPedido contextoPedido) {
        this.tipoLanche = tipoLanche;
        this.contextoPedido = contextoPedido;
    }

    @Override
    public void executar() {
        pedidoRegistrado = new PedidoBuilder()
                .setTipoLanche(tipoLanche)
                .setFormaPagamento("Pendente")
                .build();
        contextoPedido.confirmar();
        System.out.println("Pedido registrado: " + pedidoRegistrado.getTipoLanche());
    }

    @Override
    public void desfazer() {
        contextoPedido.cancelar();
        System.out.println("Pedido cancelado: " + pedidoRegistrado.getTipoLanche());
    }

    public Pedido getPedidoRegistrado() {
        return pedidoRegistrado;
    }
}
