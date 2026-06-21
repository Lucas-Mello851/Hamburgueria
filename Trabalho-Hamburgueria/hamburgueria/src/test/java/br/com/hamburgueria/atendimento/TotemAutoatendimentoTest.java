package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.pagamento.DescontoEstudante;
import br.com.hamburgueria.pedidos.CicloPedido;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TotemAutoatendimentoTest {

    @Test
    void totemInterpretaTipo() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("quero um smash com queijo");
        assertEquals("Smash", totem.getPedidoInterpretado().getTipoLanche());
    }

    @Test
    void totemMontaLancheComAdicional() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("smash com queijo");
        totem.montarLanche();
        assertEquals(Precos.HAMBURGUER_SMASH + Precos.ADICIONAL_QUEIJO,
                totem.getLancheMontado().getPreco());
    }

    @Test
    void totemRespeitaRemocao() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("classico com queijo sem tomate");
        totem.montarLanche();
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO,
                totem.getLancheMontado().getPreco());
    }

    @Test
    void totemValidaPedido() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("smash com bacon");
        totem.montarLanche();
        assertTrue(totem.validarPedido());
    }

    @Test
    void totemRegistraPedido() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("vegano");
        totem.montarLanche();
        totem.validarPedido();
        CicloPedido ciclo = totem.registrarPedido();
        assertEquals("Em preparo", ciclo.getStatus());
    }

    @Test
    void totemRegistraOperacaoNoCaixa() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("classico");
        totem.montarLanche();
        totem.validarPedido();
        totem.registrarPedido();
        assertEquals(1, totem.getOperadorCaixa().getTotalOperacoes());
    }

    @Test
    void totemAplicaDescontoEstudante() {
        TotemAutoatendimento totem = new TotemAutoatendimento();
        totem.interpretarPedido("smash");
        totem.montarLanche();
        double total = totem.calcularTotal(new DescontoEstudante());
        assertTrue(total < Precos.HAMBURGUER_SMASH);
    }

}

