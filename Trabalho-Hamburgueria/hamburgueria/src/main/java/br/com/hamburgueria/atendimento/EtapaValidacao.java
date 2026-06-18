package br.com.hamburgueria.atendimento;

public abstract class EtapaValidacao {

    protected EtapaValidacao proximo;

    public EtapaValidacao setProximo(EtapaValidacao proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract void processar(SolicitacaoPedido solicitacao);
}
