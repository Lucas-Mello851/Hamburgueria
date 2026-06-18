package br.com.hamburgueria.pedidos;

public class CicloPedido {

    private SituacaoPedido estado;

    public CicloPedido() {
        this.estado = new SituacaoAguardando();
    }

    public void setEstado(SituacaoPedido estado) {
        this.estado = estado;
    }

    public void confirmar() { estado.confirmar(this); }
    public void preparar()  { estado.preparar(this); }
    public void entregar()  { estado.entregar(this); }
    public void cancelar()  { estado.cancelar(this); }

    public String getStatus() { return estado.getStatus(); }
}
