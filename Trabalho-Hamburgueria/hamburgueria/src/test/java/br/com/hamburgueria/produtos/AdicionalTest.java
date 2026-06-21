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
    void decoratorQueijoPreco() {
        Lanche lanche = new Queijo(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO, lanche.getPreco());
    }

    @Test
    void decoratorQueijoDescricao() {
        assertTrue(new Queijo(new HamburguerClassico()).getDescricao().contains("Queijo Cheddar"));
    }

    @Test
    void decoratorBaconPreco() {
        Lanche lanche = new Bacon(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_BACON, lanche.getPreco());
    }

    @Test
    void decoratorAlfacePreco() {
        Lanche lanche = new Alface(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_ALFACE, lanche.getPreco());
    }

    @Test
    void decoratorTomatePreco() {
        Lanche lanche = new Tomate(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_TOMATE, lanche.getPreco());
    }

    @Test
    void decoratorMolhoPreco() {
        Lanche lanche = new MolhoEspecial(new HamburguerClassico());
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_MOLHO_ESPECIAL, lanche.getPreco());
    }

    @Test
    void decoratorEmpilhadoPreco() {
        Lanche lanche = new Bacon(new Queijo(new HamburguerClassico()));
        assertEquals(Precos.HAMBURGUER_CLASSICO + Precos.ADICIONAL_QUEIJO + Precos.ADICIONAL_BACON, lanche.getPreco());
    }

    @Test
    void decoratorEmpilhadoDescricao() {
        assertTrue(new Bacon(new Queijo(new HamburguerClassico())).getDescricao().contains("Queijo Cheddar"));
    }

}