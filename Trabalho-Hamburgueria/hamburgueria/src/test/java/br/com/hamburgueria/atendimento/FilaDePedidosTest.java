package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.FilaDePedidos;
import br.com.hamburgueria.atendimento.MonitorCaixa;
import br.com.hamburgueria.atendimento.MonitorCozinha;
import br.com.hamburgueria.atendimento.NotificacaoCliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilaDePedidosTest {

    @Test
    void observerCozinha() {
        FilaDePedidos fila = new FilaDePedidos();
        MonitorCozinha monitor = new MonitorCozinha();
        fila.adicionarObserver(monitor);
        fila.novoPedido("Smash");
        assertEquals("Smash", monitor.getUltimaNotificacao());
    }

    @Test
    void observerCliente() {
        FilaDePedidos fila = new FilaDePedidos();
        NotificacaoCliente cliente = new NotificacaoCliente("Joao");
        fila.adicionarObserver(cliente);
        fila.pedidoPronto("Vegano");
        assertTrue(cliente.foiNotificado());
    }

    @Test
    void observerCaixaConta() {
        FilaDePedidos fila = new FilaDePedidos();
        MonitorCaixa caixa = new MonitorCaixa();
        fila.adicionarObserver(caixa);
        fila.novoPedido("Classico");
        assertEquals(1, caixa.getTotalEventosRecebidos());
    }

    @Test
    void observerRemover() {
        FilaDePedidos fila = new FilaDePedidos();
        MonitorCaixa caixa = new MonitorCaixa();
        fila.adicionarObserver(caixa);
        fila.novoPedido("Classico");
        fila.removerObserver(caixa);
        fila.novoPedido("Smash");
        assertEquals(1, caixa.getTotalEventosRecebidos());
    }

    @Test
    void observerClienteNaoNotificado() {
        FilaDePedidos fila = new FilaDePedidos();
        NotificacaoCliente cliente = new NotificacaoCliente("Maria");
        fila.adicionarObserver(cliente);
        fila.novoPedido("Smash");
        assertFalse(cliente.foiNotificado());
    }

}