package Classes;

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
        System.out.println("Adicionado: " + ingrediente + " -> " + adicionais);
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public EstadoPedidoMemento salvarEstado() {
        EstadoPedidoMemento estado = new EstadoPedidoMemento(tipoLanche, adicionais, observacao);
        return estado;
    }

    public void restaurarEstado(EstadoPedidoMemento memento) {
        String tipoSalvo = memento.getTipoLanche();
        List<String> adicionaisSalvos = memento.getAdicionais();
        String obsSalva = memento.getObservacao();

        this.tipoLanche = tipoSalvo;
        this.adicionais = adicionaisSalvos;
        this.observacao = obsSalva;

        System.out.println("Estado restaurado: " + adicionais);
    }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return adicionais; }
    public String getObservacao() { return observacao; }

    @Override
    public String toString() {
        return "PedidoEmMontagem{tipo=" + tipoLanche + ", adicionais=" + adicionais + ", obs='" + observacao + "'}";
    }
}
