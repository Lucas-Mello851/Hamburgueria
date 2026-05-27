package br.com.hamburgueria.chainofresponsibility;

public class SolicitacaoPedido {

    private final String tipo;
    private final double valor;
    private boolean processado = false;

    public SolicitacaoPedido(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public boolean isProcessado() { return processado; }
    public void setProcessado(boolean processado) { this.processado = processado; }
}
