package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Cardapio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void singletonMesmaInstancia() {
        assertSame(Cardapio.getInstance(), Cardapio.getInstance());
    }

    @Test
    void singletonTipoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Cardapio.getInstance().getFabrica("Inexistente"));
    }

    @Test
    void singletonRetornaFabrica() {
        assertNotNull(Cardapio.getInstance().getFabrica("Clássico"));
    }

    @Test
    void singletonDescreveCardapio() {
        assertTrue(Cardapio.getInstance().descreverCardapio().contains("LANCHES BASE"));
    }

}