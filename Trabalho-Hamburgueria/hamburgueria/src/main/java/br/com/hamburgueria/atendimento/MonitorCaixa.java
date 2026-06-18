package br.com.hamburgueria.atendimento;

public class MonitorCaixa implements AcompanhantepPedido {

    private int totalEventosRecebidos = 0;
    private String ultimoEvento;

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        this.ultimoEvento = evento;
        this.totalEventosRecebidos++;
    }

    public int getTotalEventosRecebidos() {
        return totalEventosRecebidos;
    }

    public String getUltimoEvento() {
        return ultimoEvento;
    }
}
