package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.CardapioComCombos;
import br.com.hamburgueria.cardapio.Combo;
import br.com.hamburgueria.cardapio.ItemCardapio;
import br.com.hamburgueria.cardapio.ItemSimples;
import br.com.hamburgueria.cardapio.PercursoCardapioCompleto;
import br.com.hamburgueria.cardapio.PercursoItensPorTipo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PercursoCardapioTest {

    @Test
    void iteratorPercorreTotal() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        PercursoCardapioCompleto iterator = new PercursoCardapioCompleto(combos);
        int total = 0;
        while (iterator.temProximo()) {
            iterator.proximo();
            total++;
        }
        assertEquals(iterator.getTotalItens(), total);
    }

    @Test
    void iteratorReinicia() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        PercursoCardapioCompleto iterator = new PercursoCardapioCompleto(combos);
        ItemCardapio primeiro = iterator.proximo();
        iterator.reiniciar();
        assertEquals(primeiro.getNome(), iterator.proximo().getNome());
    }

    @Test
    void iteratorAlemDoFim() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        PercursoCardapioCompleto iterator = new PercursoCardapioCompleto(combos);
        while (iterator.temProximo()) {
            iterator.proximo();
        }
        assertThrows(IllegalStateException.class, iterator::proximo);
    }

    @Test
    void iteratorPorTipo() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        PercursoItensPorTipo iterator = new PercursoItensPorTipo(combos, ItemSimples.class);
        boolean todosSimples = true;
        while (iterator.temProximo()) {
            if (!(iterator.proximo() instanceof ItemSimples)) {
                todosSimples = false;
            }
        }
        assertTrue(todosSimples);
    }

}