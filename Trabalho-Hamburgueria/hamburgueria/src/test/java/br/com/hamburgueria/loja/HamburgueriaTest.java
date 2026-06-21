package br.com.hamburgueria.loja;

import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.dominio.ProcessoCheckout;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.cardapio.NivelAcesso;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class HamburgueriaTest {

    private final Hamburgueria loja = new Hamburgueria();

    @Test
    void criaLanches() {
        assertNotNull(loja.criarLancheClassico());
        assertNotNull(loja.criarLancheSmash());
        assertNotNull(loja.criarLancheVegano());
    }

    @Test
    void bebidas() {
        assertNotNull(loja.pedirRefrigerante());
        assertNotNull(loja.pedirSuco());
    }

    @Test
    void montaLanche() {
        Lanche l = loja.montarLanche("classico com queijo");
        assertNotNull(l);
        assertTrue(l.getPreco() > 0);
    }

    @Test
    void montaPedido() {
        Pedido p = loja.montarPedido("smash");
        assertNotNull(p);
        assertNotNull(p.getLanche());
    }

    @Test
    void realiza() {
        FormaPagamento pix = loja.formaDePagamento("PIX");
        Pedido p = loja.realizarPedido("classico", pix);
        assertTrue(p.isPago());
    }

    @Test
    void checkoutBalcao() {
        ProcessoCheckout.ResultadoCheckout r = loja.checkoutBalcao("vegano", loja.formaDePagamento("DINHEIRO"));
        assertTrue(r.isAprovado());
        assertEquals("Balcao", r.getCanal());
    }

    @Test
    void checkoutDelivery() {
        ProcessoCheckout.ResultadoCheckout r = loja.checkoutDelivery("smash", loja.formaDePagamento("PIX"), "Rua X");
        assertEquals("Delivery", r.getCanal());
    }

    @Test
    void cupom() {
        assertNotNull(loja.cupom("ESTUDANTE"));
        assertTrue(loja.totalComCupom("classico", "PROMO10") > 0);
    }

    @Test
    void catalogos() {
        assertFalse(loja.etapasDaReceita("CLASSICO").isEmpty());
        assertEquals(9, loja.ingredientesDisponiveis().size());
    }

    @Test
    void proxy() {
        assertNotNull(loja.gerenciarComo(NivelAcesso.GERENTE));
    }

    @Test
    void ficha() {
        assertNotNull(loja.fichaTecnica("classico"));
    }

    @Test
    void atende() {
        assertNotNull(loja.atender("classico"));
    }

    @Test
    void subsistemas() {
        assertNotNull(loja.getAtendimento());
        assertNotNull(loja.getTotem());
        assertNotNull(loja.getCardapio());
        assertNotNull(loja.getPagamentos());
        assertNotNull(loja.getReceitas());
        assertNotNull(loja.getIngredientes());
        assertNotNull(loja.getFavoritos());
        assertNotNull(loja.getCupons());
        assertNotNull(loja.getCalculadoraDesconto());
        assertNotNull(loja.getCardapioCombos());
        assertNotNull(loja.novoMontador());
    }
}
