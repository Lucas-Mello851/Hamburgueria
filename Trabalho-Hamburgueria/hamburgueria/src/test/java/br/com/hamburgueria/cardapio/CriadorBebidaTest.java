package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.produtos.RefrigeranteLata;
import br.com.hamburgueria.produtos.SucoNatural;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CriadorBebidaTest {

    @Test
    void criaRefrigerante() {
        CriadorBebida criador = new CriadorRefrigerante();
        Bebida b = criador.criar();
        assertInstanceOf(RefrigeranteLata.class, b);
        assertTrue(b.getPreco() > 0);
    }

    @Test
    void criaSuco() {
        CriadorBebida criador = new CriadorSuco();
        Bebida b = criador.criar();
        assertInstanceOf(SucoNatural.class, b);
        assertNotNull(b.getDescricao());
    }

    @Test
    void instanciasDistintas() {
        CriadorBebida criador = new CriadorRefrigerante();
        assertNotSame(criador.criar(), criador.criar());
    }
}

