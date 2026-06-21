package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.cardapio.CardapioComCombos;
import br.com.hamburgueria.cardapio.CardapioPercorrivel;
import br.com.hamburgueria.cardapio.PercursoCardapio;
import br.com.hamburgueria.pagamento.PagamentoCartao;
import br.com.hamburgueria.pagamento.PagamentoPix;
import br.com.hamburgueria.pedidos.HistoricoMontagem;
import br.com.hamburgueria.pedidos.PedidoEmMontagem;
import br.com.hamburgueria.pedidos.PedidoFavorito;
import br.com.hamburgueria.pedidos.PedidoTextoLido;
import br.com.hamburgueria.produtos.Queijo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class IntegracaoTest {

    @Test
    void integracaoIteratorCardapioIteravel() {
        PercursoCardapio it = CardapioComCombos.getInstance().criarIterator();
        assertTrue(it.temProximo());
    }

    @Test
    void integracaoObserverMediator() {
        Cozinha cozinha = new Cozinha();
        PostoCaixa caixa = new PostoCaixa();
        Entregador entregador = new Entregador();
        CentralAtendimentoRestaurante mediator = new CentralAtendimentoRestaurante(cozinha, caixa, entregador);
        FilaDePedidos fila = new FilaDePedidos();
        MonitorCozinha monitor = new MonitorCozinha();
        fila.adicionarObserver(monitor);
        mediator.setFilaPedidos(fila);
        caixa.registrarPedido("Smash");
        assertEquals("Smash", monitor.getUltimaNotificacao());
    }

    @Test
    void integracaoInterpreterFacade() {
        PedidoTextoLido ctx = new AtendimentoHamburgueria().pedirPorTexto("quero um smash com queijo");
        assertEquals("Smash", ctx.getTipoLanche());
    }

    @Test
    void integracaoMementoFacade() {
        AtendimentoHamburgueria facade = new AtendimentoHamburgueria();
        HistoricoMontagem historico = new HistoricoMontagem();
        PedidoEmMontagem montagem = facade.iniciarMontagem("Classico");
        facade.salvarEstadoMontagem(montagem, historico);
        montagem.adicionarIngrediente("Queijo");
        facade.desfazerMontagem(montagem, historico);
        assertFalse(montagem.getAdicionais().contains("Queijo"));
    }

    @Test
    void integracaoPrototypeFacade() {
        AtendimentoHamburgueria facade = new AtendimentoHamburgueria();
        PedidoFavorito original = new PedidoFavorito("Smash", new ArrayList<>(), "sem cebola");
        facade.salvarFavorito("meu pedido", original);
        PedidoFavorito clone = facade.pedirFavorito("meu pedido");
        assertNotSame(original, clone);
    }

    @Test
    void integracaoTemplateMethodFacade() {
        List<String> etapas = new AtendimentoHamburgueria().obterEtapasPreparo("Smash");
        assertEquals(4, etapas.size());
    }

    @Test
    void integracaoBridgeFacadeBalcao() {
        boolean resultado = new AtendimentoHamburgueria().finalizarPedidoBalcao("Smash", 28.0, new PagamentoPix());
        assertTrue(resultado);
    }

    @Test
    void integracaoBridgeFacadeDelivery() {
        boolean resultado = new AtendimentoHamburgueria().finalizarPedidoDelivery("Classico", 22.0, "Rua A, 123", new PagamentoCartao("Credito"));
        assertTrue(resultado);
    }

}