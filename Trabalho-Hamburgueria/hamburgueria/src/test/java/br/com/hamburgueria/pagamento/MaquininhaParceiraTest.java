package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pagamento.MaquininhaExterna;
import br.com.hamburgueria.pagamento.MaquininhaParceira;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MaquininhaParceiraTest {

    @Test
    void adapterProcessa() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Stone"));
        assertTrue(adapter.processar(35.0));
    }

    @Test
    void adapterNome() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Cielo"));
        assertTrue(adapter.getNome().contains("Cielo"));
    }

    @Test
    void adapterRecusa() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Stone"));
        assertFalse(adapter.processar(600.0));
    }

    @Test
    void adapterOperadora() {
        assertEquals("Stone", new MaquininhaExterna("Stone").getOperadora());
    }

}