package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.pagamento.PagamentoPix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class FluxoDistribuidoTest {

    @Test
    void cozinhaUsaReceita() {
        FichaTecnica f = FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 1, 1, 1);
        Pedido p = new Pedido(new HamburguerClassico(), f);
        p.pagar(new PagamentoPix());
        Cozinha cozinha = new Cozinha();
        CentralAtendimentoRestaurante m = new CentralAtendimentoRestaurante(cozinha, new PostoCaixa(), new Entregador());
        cozinha.setMediator(m);
        cozinha.receberPedido(p);
        cozinha.prepararPedido();
        assertNotNull(cozinha.getUltimasEtapasPreparo());
        assertNotNull(cozinha.getCatalogoReceitas());
    }

    @Test
    void caixaEmiteRecibo() {
        PostoCaixa caixa = new PostoCaixa();
        var recibo = caixa.emitirRecibo("Classico", new PagamentoPix(), 22.0);
        assertNotNull(recibo);
        assertSame(recibo, caixa.getUltimoRecibo());
        assertEquals("Classico", recibo.getPedido().getTipoLanche());
    }

    @Test
    void totemValidacaoComoCampo() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("classico");
        totem.montarLanche();
        totem.validarPedido();
        assertNotNull(totem.getCadeiaValidacao());
        assertNotNull(totem.getSolicitacaoAtual());
    }
}
