package br.com.hamburgueria.pedidos;

import java.util.ArrayList;
import java.util.List;

public class PedidoEmMontagem {

    private String tipoLanche;
    private List<String> adicionais;
    private String observacao;

    public PedidoEmMontagem() {
        adicionais = new ArrayList<>();
        observacao = "";
    }

    public void setTipoLanche(String tipoLanche) {
        this.tipoLanche = tipoLanche;
    }

    public void adicionarIngrediente(String ingrediente) {
        adicionais.add(ingrediente);
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public RegistroMontagem salvarEstado() {
        return new RegistroMontagem(tipoLanche, adicionais, observacao);
    }

    public void restaurarEstado(RegistroMontagem memento) {
        this.tipoLanche = memento.getTipoLanche();
        this.adicionais = memento.getAdicionais();
        this.observacao = memento.getObservacao();
    }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return adicionais; }
    public String getObservacao() { return observacao; }

    @Override
    public String toString() {
        return "PedidoEmMontagem{tipo=" + tipoLanche + ", adicionais=" + adicionais + ", obs='" + observacao + "'}";
    }
}
