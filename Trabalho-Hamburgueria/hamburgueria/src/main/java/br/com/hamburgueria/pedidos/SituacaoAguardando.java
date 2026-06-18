package br.com.hamburgueria.pedidos;

public class SituacaoAguardando implements SituacaoPedido {

    @Override
    public void confirmar(CicloPedido contexto) {
        contexto.setEstado(new SituacaoEmPreparo());
    }

    @Override
    public void preparar(CicloPedido contexto) {
    }

    @Override
    public void entregar(CicloPedido contexto) {
    }

    @Override
    public void cancelar(CicloPedido contexto) {
        contexto.setEstado(new SituacaoCancelado());
    }

    @Override
    public String getStatus() { return "Aguardando confirmacao"; }
}
