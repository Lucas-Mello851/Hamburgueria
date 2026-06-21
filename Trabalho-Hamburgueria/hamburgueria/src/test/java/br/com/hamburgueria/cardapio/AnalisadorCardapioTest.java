package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.AnalisadorPorPreco;
import br.com.hamburgueria.cardapio.AnalisadorResumo;
import br.com.hamburgueria.cardapio.Combo;
import br.com.hamburgueria.cardapio.ItemSimples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnalisadorCardapioTest {

    @Test
    void visitorResumoTotal() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        combo.adicionar(new ItemSimples("B", 15.0));
        AnalisadorResumo visitor = new AnalisadorResumo();
        combo.aceitar(visitor);
        assertEquals(25.0, visitor.getTotalGeral());
    }

    @Test
    void visitorResumoContagem() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("A", 10.0));
        AnalisadorResumo visitor = new AnalisadorResumo();
        combo.aceitar(visitor);
        assertTrue(visitor.getTotalItens() >= 1);
    }

    @Test
    void visitorFiltro() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("Barato", 5.0));
        combo.adicionar(new ItemSimples("Caro", 50.0));
        AnalisadorPorPreco visitor = new AnalisadorPorPreco(10.0);
        combo.aceitar(visitor);
        assertEquals(1, visitor.getItensFiltrados().size());
    }

}