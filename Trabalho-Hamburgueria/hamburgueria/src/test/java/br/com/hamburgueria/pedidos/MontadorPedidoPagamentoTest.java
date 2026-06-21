package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pagamento.PagamentoPix;
import br.com.hamburgueria.pagamento.PagamentoCartao;
import br.com.hamburgueria.pagamento.FormaPagamento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MontadorPedidoPagamentoTest {

    @Test
    void builderAceitaFormaConcreta() {
        PedidoMontado p = new MontadorPedido()
                .setTipoLanche("Smash")
                .setFormaPagamento(new PagamentoPix())
                .build();
        assertEquals("PIX", p.getFormaPagamento());
        assertNotNull(p.getFormaPagamentoReal());
    }

    @Test
    void pedidoMontadoCobra() {
        PedidoMontado p = new MontadorPedido()
                .setTipoLanche("Classico")
                .setFormaPagamento(new PagamentoCartao("Credito"))
                .build();
        assertTrue(p.cobrar(30.0));
    }

    @Test
    void semFormaRealNaoCobra() {
        PedidoMontado p = new MontadorPedido()
                .setTipoLanche("Vegano")
                .setFormaPagamento("Dinheiro")
                .build();
        assertFalse(p.cobrar(20.0));
    }

    @Test
    void nomeViraRotulo() {
        FormaPagamento pix = new PagamentoPix();
        PedidoMontado p = new MontadorPedido()
                .setTipoLanche("Smash")
                .setFormaPagamento(pix)
                .build();
        assertEquals(pix.getNome(), p.getFormaPagamento());
    }
}

