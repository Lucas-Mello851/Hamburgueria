package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.HistoricoMontagem;
import br.com.hamburgueria.pedidos.PedidoEmMontagem;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HistoricoMontagemTest {

    @Test
    @DisplayName("Memento: desfazer mantem ingrediente anterior")
    void mementoMantemAnterior() {
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        HistoricoMontagem historico = new HistoricoMontagem();
        pedido.setTipoLanche("Smash");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Queijo");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Bacon");
        pedido.restaurarEstado(historico.desfazer());
        assertTrue(pedido.getAdicionais().contains("Queijo"));
    }

    @Test
    @DisplayName("Memento: desfazer remove o ultimo ingrediente")
    void mementoRemoveUltimo() {
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        HistoricoMontagem historico = new HistoricoMontagem();
        pedido.setTipoLanche("Smash");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Queijo");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Bacon");
        pedido.restaurarEstado(historico.desfazer());
        assertFalse(pedido.getAdicionais().contains("Bacon"));
    }

    @Test
    @DisplayName("Memento: historico cresce a cada salvamento")
    void mementoTamanho() {
        HistoricoMontagem historico = new HistoricoMontagem();
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        pedido.setTipoLanche("Vegano");
        historico.salvar(pedido.salvarEstado());
        assertEquals(1, historico.getTamanho());
    }

    @Test
    @DisplayName("Memento: desfazer sem historico lanca excecao")
    void mementoSemHistorico() {
        assertThrows(IllegalStateException.class, () -> new HistoricoMontagem().desfazer());
    }

    @Test
    @DisplayName("Memento: memento guarda o tipo do lanche")
    void mementoGuardaTipo() {
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        pedido.setTipoLanche("Smash");
        assertEquals("Smash", pedido.salvarEstado().getTipoLanche());
    }

}