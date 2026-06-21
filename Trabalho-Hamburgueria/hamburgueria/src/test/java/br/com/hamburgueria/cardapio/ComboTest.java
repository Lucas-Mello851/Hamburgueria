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
    void compositeSomaPreco() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        combo.adicionar(new ItemSimples("B", 15.0));
        assertEquals(25.0, combo.getPreco());
    }

    @Test
    void compositeRemoverItem() {
        Combo combo = new Combo("Teste");
        ItemSimples item = new ItemSimples("A", 10.0);
        combo.adicionar(item);
        combo.adicionar(new ItemSimples("B", 15.0));
        combo.remover(item);
        assertEquals(15.0, combo.getPreco());
    }

    @Test
    void compositeNome() {
        assertEquals("Combo X", new Combo("Combo X").getNome());
    }

    @Test
    void compositeItemSimplesPreco() {
        assertEquals(8.0, new ItemSimples("Batata", 8.0).getPreco());
    }

    @Test
    void compositeDescrever() {
        assertTrue(new ItemSimples("Batata", 8.0).descrever("").contains("Batata"));
    }

    @Test
    void compositeListaItens() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        assertEquals(1, combo.getItens().size());
    }

    @Test
    void compositeTresCombos() {
        assertEquals(3, CardapioComCombos.getInstance().getCombos().size());
    }

    @Test
    void compositeComboInexistente() {
        assertThrows(IllegalArgumentException.class, () -> CardapioComCombos.getInstance().getCombo("Inexistente"));
    }

}