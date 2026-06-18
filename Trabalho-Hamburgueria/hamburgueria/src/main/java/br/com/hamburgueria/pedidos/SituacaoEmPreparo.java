package br.com.hamburgueria.pedidos;

public class SituacaoEmPreparo implements SituacaoPedido {

    @Override
    public void confirmar(CicloPedido contexto) {
    }

    @Override
    public void preparar(CicloPedido contexto) {
        contexto.setEstado(new SituacaoPronto());
    }

    @Override
    public void entregar(CicloPedido contexto) {
    }

    @Override
    public void cancelar(CicloPedido contexto) {
        contexto.setEstado(new SituacaoCancelado());
    }

    @Override
    public String getStatus() { return "Em preparo"; }
}
