package Classes;

public class ContextoPedido {

    private EstadoPedido estado;

    public ContextoPedido() {
        this.estado = new EstadoAguardando();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void confirmar() { estado.confirmar(this); }
    public void preparar()  { estado.preparar(this); }
    public void entregar()  { estado.entregar(this); }
    public void cancelar()  { estado.cancelar(this); }
    public void pausar()    { estado.pausar(this); }
    public void retomar()   { estado.retomar(this); }

    public String getStatus() { return estado.getStatus(); }
}
