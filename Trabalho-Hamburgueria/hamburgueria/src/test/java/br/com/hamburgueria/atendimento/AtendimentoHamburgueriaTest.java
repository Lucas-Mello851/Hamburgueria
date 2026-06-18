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
    @DisplayName("Facade: lanche simples tem o preco base")
    void facadeSimples() {
        assertEquals(Precos.HAMBURGUER_CLASSICO, new AtendimentoHamburgueria().pedirLancheSimples("Clássico").getPreco());
    }

    @Test
    @DisplayName("Facade: lanche com queijo soma o adicional")
    void facadeComQueijo() {
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO,
                new AtendimentoHamburgueria().pedirLancheComQueijo("Clássico").getPreco());
    }

    @Test
    @DisplayName("Facade: lanche com bacon soma o adicional")
    void facadeComBacon() {
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_BACON,
                new AtendimentoHamburgueria().pedirLancheComBacon("Clássico").getPreco());
    }

    @Test
    @DisplayName("Facade: lanche completo soma todos os adicionais")
    void facadeCompleto() {
        double esperado = Precos.HAMBURGUER_SMASH + Precos.ADICIONAL_QUEIJO + Precos.ADICIONAL_BACON
                + Precos.ADICIONAL_ALFACE + Precos.ADICIONAL_TOMATE + Precos.ADICIONAL_MOLHO_ESPECIAL;
        assertEquals(esperado, new AtendimentoHamburgueria().pedirLancheCompleto("Smash").getPreco());
    }

}