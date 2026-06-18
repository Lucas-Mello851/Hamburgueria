package br.com.hamburgueria.pedidos;

public class SituacaoEntregue implements SituacaoPedido {

    @Override
    public void confirmar(CicloPedido contexto) {
    }

    @Override
    public void preparar(CicloPedido contexto) {
    }

    @Override
    public void entregar(CicloPedido contexto) {
    }

    @Override
    public void cancelar(CicloPedido contexto) {
    }

    @Override
    public String getStatus() {
        return "Entregue";
    }
}
