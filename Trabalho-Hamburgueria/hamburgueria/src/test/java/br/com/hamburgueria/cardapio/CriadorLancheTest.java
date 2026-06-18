package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.CriadorLancheClassico;
import br.com.hamburgueria.cardapio.CriadorLancheSmash;
import br.com.hamburgueria.cardapio.CriadorLancheVegano;
import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.produtos.HamburguerSmash;
import br.com.hamburgueria.produtos.HamburguerVegano;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CriadorLancheTest {

    @Test
    @DisplayName("Factory: CriadorLancheClassico cria instancia de HamburguerClassico")
    void factoryClassicoTipo() {
        assertInstanceOf(HamburguerClassico.class, new CriadorLancheClassico().criar());
    }

    @Test
    @DisplayName("Factory: CriadorLancheClassico cria lanche com preco do classico")
    void factoryClassicoPreco() {
        assertEquals(Precos.HAMBURGUER_CLASSICO, new CriadorLancheClassico().criar().getPreco());
    }

    @Test
    @DisplayName("Factory: CriadorLancheSmash cria instancia de HamburguerSmash")
    void factorySmashTipo() {
        assertInstanceOf(HamburguerSmash.class, new CriadorLancheSmash().criar());
    }

    @Test
    @DisplayName("Factory: CriadorLancheSmash cria lanche com preco do smash")
    void factorySmashPreco() {
        assertEquals(Precos.HAMBURGUER_SMASH, new CriadorLancheSmash().criar().getPreco());
    }

    @Test
    @DisplayName("Factory: CriadorLancheVegano cria instancia de HamburguerVegano")
    void factoryVeganoTipo() {
        assertInstanceOf(HamburguerVegano.class, new CriadorLancheVegano().criar());
    }

    @Test
    @DisplayName("Factory: CriadorLancheVegano cria lanche com preco do vegano")
    void factoryVeganoPreco() {
        assertEquals(Precos.HAMBURGUER_VEGANO, new CriadorLancheVegano().criar().getPreco());
    }

}