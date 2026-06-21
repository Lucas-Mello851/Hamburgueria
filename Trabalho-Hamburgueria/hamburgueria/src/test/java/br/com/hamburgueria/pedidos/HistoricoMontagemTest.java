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
    void mementoTamanho() {
        HistoricoMontagem historico = new HistoricoMontagem();
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        pedido.setTipoLanche("Vegano");
        historico.salvar(pedido.salvarEstado());
        assertEquals(1, historico.getTamanho());
    }

    @Test
    void mementoSemHistorico() {
        assertThrows(IllegalStateException.class, () -> new HistoricoMontagem().desfazer());
    }

    @Test
    void mementoGuardaTipo() {
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        pedido.setTipoLanche("Smash");
        assertEquals("Smash", pedido.salvarEstado().getTipoLanche());
    }

}