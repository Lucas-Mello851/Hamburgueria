package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CozinhaPedidoTest {

    private Pedido pedido() {
        FichaTecnica f = FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 1, 1, 1);
        return new Pedido(new HamburguerClassico(), f);
    }

    @Test
    void recebePedido() {
        Pedido p = pedido();
        Cozinha cozinha = new Cozinha();
        CentralAtendimentoRestaurante m = new CentralAtendimentoRestaurante(cozinha, new PostoCaixa(), new Entregador());
        cozinha.setMediator(m);
        cozinha.receberPedido(p);
        assertSame(p, cozinha.getPedidoEmPreparo());
        assertNotNull(cozinha.getPedidoAtual());
    }

    @Test
    void prepararAvancaEstado() {
        Pedido p = pedido();
        p.pagar(new br.com.hamburgueria.pagamento.PagamentoPix());
        Cozinha cozinha = new Cozinha();
        CentralAtendimentoRestaurante m = new CentralAtendimentoRestaurante(cozinha, new PostoCaixa(), new Entregador());
        cozinha.setMediator(m);
        cozinha.receberPedido(p);
        cozinha.prepararPedido();
        assertEquals("Pronto", p.getStatus());
    }

    @Test
    void fichaAssociada() {
        Pedido p = pedido();
        assertTrue(p.getFichaTecnica().confereComLanche());
        assertSame(p.getLanche(), p.getFichaTecnica().getLanche());
    }
}
