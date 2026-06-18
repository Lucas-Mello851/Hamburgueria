package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Cardapio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    @DisplayName("Singleton: getInstance retorna a mesma instancia")
    void singletonMesmaInstancia() {
        assertSame(Cardapio.getInstance(), Cardapio.getInstance());
    }

    @Test
    @DisplayName("Singleton: tipo invalido lanca excecao")
    void singletonTipoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Cardapio.getInstance().getFabrica("Inexistente"));
    }

    @Test
    @DisplayName("Singleton: getFabrica retorna fabrica para tipo valido")
    void singletonRetornaFabrica() {
        assertNotNull(Cardapio.getInstance().getFabrica("Clássico"));
    }

    @Test
    @DisplayName("Singleton: descreverCardapio inclui os lanches base")
    void singletonDescreveCardapio() {
        assertTrue(Cardapio.getInstance().descreverCardapio().contains("LANCHES BASE"));
    }

}