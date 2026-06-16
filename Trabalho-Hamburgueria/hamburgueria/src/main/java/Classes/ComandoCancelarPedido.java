package Classes;

import Classes.ContextoPedido;

public class ComandoCancelarPedido implements Comando {

    private ContextoPedido contextoPedido;
    private String statusAnterior;

    public ComandoCancelarPedido(ContextoPedido contextoPedido) {
        this.contextoPedido = contextoPedido;
    }

    @Override
    public void executar() {
        statusAnterior = contextoPedido.getStatus();
        contextoPedido.cancelar();
        System.out.println("Pedido cancelado pelo caixa.");
    }

    @Override
    public void desfazer() {
        System.out.println("Nao e possivel reativar um pedido cancelado. Status anterior era: " + statusAnterior);
    }
}
