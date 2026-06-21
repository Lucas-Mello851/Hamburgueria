package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.AtendimentoHamburgueria;
import br.com.hamburgueria.cardapio.Precos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AtendimentoHamburgueriaTest {

    @Test
    void facadeSimples() {
        assertEquals(Precos.HAMBURGUER_CLASSICO, new AtendimentoHamburgueria().pedirLancheSimples("Clássico").getPreco());
    }

    @Test
    void facadeComQueijo() {
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO,
                new AtendimentoHamburgueria().pedirLancheComQueijo("Clássico").getPreco());
    }

    @Test
    void facadeAtenderPorTexto() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        assertEquals("Em preparo", atendimento.atenderPorTexto("smash com queijo").getStatus());
    }

    @Test
    void facadeAtenderColocaNoPainel() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        atendimento.atenderPorTexto("classico");
        assertTrue(atendimento.getPainelDeChamada().getEmPreparo().contains("Clássico"));
    }

    @Test
    void facadeAnunciaPronto() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        atendimento.atenderPorTexto("vegano");
        atendimento.anunciarPedidoPronto("Vegano");
        assertEquals("Vegano", atendimento.getPainelDeChamada().getUltimoChamado());
    }

    @Test
    void facadeMontaLanchePorTexto() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        assertEquals(Precos.HAMBURGUER_SMASH + Precos.ADICIONAL_BACON,
                atendimento.montarLanchePorTexto("smash com bacon").getPreco());
    }

    @Test
    void facadeComBacon() {
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_BACON,
                new AtendimentoHamburgueria().pedirLancheComBacon("Clássico").getPreco());
    }

    @Test
    void facadeCompleto() {
        double esperado = Precos.HAMBURGUER_SMASH + Precos.ADICIONAL_QUEIJO + Precos.ADICIONAL_BACON
                + Precos.ADICIONAL_ALFACE + Precos.ADICIONAL_TOMATE + Precos.ADICIONAL_MOLHO_ESPECIAL;
        assertEquals(esperado, new AtendimentoHamburgueria().pedirLancheCompleto("Smash").getPreco());
    }

}
