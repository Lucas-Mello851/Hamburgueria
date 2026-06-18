package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.produtos.MolhoEspecial;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdicionalTest {

    @Test
    @DisplayName("Decorator: queijo soma o preco do adicional")
    void decoratorQueijoPreco() {
        Lanche lanche = new Queijo(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: queijo aparece na descricao")
    void decoratorQueijoDescricao() {
        assertTrue(new Queijo(new HamburguerClassico()).getDescricao().contains("Queijo Cheddar"));
    }

    @Test
    @DisplayName("Decorator: bacon soma o preco do adicional")
    void decoratorBaconPreco() {
        Lanche lanche = new Bacon(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_BACON, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: alface soma o preco do adicional")
    void decoratorAlfacePreco() {
        Lanche lanche = new Alface(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_ALFACE, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: tomate soma o preco do adicional")
    void decoratorTomatePreco() {
        Lanche lanche = new Tomate(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_TOMATE, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: molho especial soma o preco do adicional")
    void decoratorMolhoPreco() {
        Lanche lanche = new MolhoEspecial(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_MOLHO_ESPECIAL, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: decoradores empilhados somam os adicionais")
    void decoratorEmpilhadoPreco() {
        Lanche lanche = new Bacon(new Queijo(new HamburguerClassico()));
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO + Precos.ADICIONAL_BACON, lanche.getPreco());
    }

    @Test
    @DisplayName("Decorator: empilhado mantem o primeiro adicional na descricao")
    void decoratorEmpilhadoDescricao() {
        assertTrue(new Bacon(new Queijo(new HamburguerClassico())).getDescricao().contains("Queijo Cheddar"));
    }

}