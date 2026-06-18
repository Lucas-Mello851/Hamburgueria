package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.CardapioComCombos;
import br.com.hamburgueria.cardapio.Combo;
import br.com.hamburgueria.cardapio.ItemSimples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    @Test
    @DisplayName("Composite: combo soma o preco dos itens")
    void compositeSomaPreco() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        combo.adicionar(new ItemSimples("B", 15.0));
        assertEquals(25.0, combo.getPreco());
    }

    @Test
    @DisplayName("Composite: remover item reduz o total")
    void compositeRemoverItem() {
        Combo combo = new Combo("Teste");
        ItemSimples item = new ItemSimples("A", 10.0);
        combo.adicionar(item);
        combo.adicionar(new ItemSimples("B", 15.0));
        combo.remover(item);
        assertEquals(15.0, combo.getPreco());
    }

    @Test
    @DisplayName("Composite: combo retorna o nome")
    void compositeNome() {
        assertEquals("Combo X", new Combo("Combo X").getNome());
    }

    @Test
    @DisplayName("Composite: item simples retorna o preco")
    void compositeItemSimplesPreco() {
        assertEquals(8.0, new ItemSimples("Batata", 8.0).getPreco());
    }

    @Test
    @DisplayName("Composite: descrever inclui o nome do item")
    void compositeDescrever() {
        assertTrue(new ItemSimples("Batata", 8.0).descrever("").contains("Batata"));
    }

    @Test
    @DisplayName("Composite: combo lista os itens adicionados")
    void compositeListaItens() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        assertEquals(1, combo.getItens().size());
    }

    @Test
    @DisplayName("Composite: cardapio registra tres combos")
    void compositeTresCombos() {
        assertEquals(3, CardapioComCombos.getInstance().getCombos().size());
    }

    @Test
    @DisplayName("Composite: combo inexistente lanca excecao")
    void compositeComboInexistente() {
        assertThrows(IllegalArgumentException.class, () -> CardapioComCombos.getInstance().getCombo("Inexistente"));
    }

}