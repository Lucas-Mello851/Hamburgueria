package br.com.hamburgueria.dominio;

import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.pagamento.PagamentoPix;
import br.com.hamburgueria.pagamento.PagamentoCartao;
import br.com.hamburgueria.pagamento.DescontoEstudante;
import br.com.hamburgueria.pagamento.DescontoPadrao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PedidoIntegracaoTest {

    private Lanche lancheComQueijoEBacon() {
        return new Bacon(new Queijo(new HamburguerClassico()));
    }

    private FichaTecnica ficha() {
        return FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 1, 1, 1);
    }

    @Test
    void totalUsaPrecoDoLancheDecorado() {
        Lanche l = lancheComQueijoEBacon();
        Pedido p = new Pedido(l, ficha());
        assertEquals(l.getPreco(), p.getTotal());
    }

    @Test
    void descontoEstudanteReduzTotal() {
        Pedido p = new Pedido(lancheComQueijoEBacon(), ficha(), new DescontoEstudante());
        Pedido cheio = new Pedido(lancheComQueijoEBacon(), ficha(), new DescontoPadrao());
        assertTrue(p.getTotal() < cheio.getTotal());
    }

    @Test
    void pagarAvancaEstado() {
        Pedido p = new Pedido(lancheComQueijoEBacon(), ficha());
        assertEquals("Aguardando confirmacao", p.getStatus());
        assertTrue(p.pagar(new PagamentoPix()));
        assertEquals("Em preparo", p.getStatus());
    }

    @Test
    void cicloCompleto() {
        Pedido p = new Pedido(lancheComQueijoEBacon(), ficha());
        p.pagar(new PagamentoCartao("Credito"));
        p.marcarPronto();
        assertEquals("Pronto", p.getStatus());
        p.marcarEntregue();
        assertEquals("Entregue", p.getStatus());
    }

    @Test
    void fichaViajaNoPedido() {
        Pedido p = new Pedido(lancheComQueijoEBacon(), ficha());
        assertNotNull(p.getFichaTecnica());
        assertTrue(p.getFichaTecnica().getTotalIngredientes() > 0);
    }

    @Test
    void descricaoCruzaPacotes() {
        Pedido p = new Pedido(lancheComQueijoEBacon(), ficha());
        p.pagar(new PagamentoPix());
        String d = p.descrever();
        assertTrue(d.contains("Pagamento"));
        assertTrue(d.contains("Status"));
    }
}

