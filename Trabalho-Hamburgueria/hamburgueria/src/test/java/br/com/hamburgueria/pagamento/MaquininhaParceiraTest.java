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
    @DisplayName("Adapter: processa pagamento via FormaPagamento")
    void adapterProcessa() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Stone"));
        assertTrue(adapter.processar(35.0));
    }

    @Test
    @DisplayName("Adapter: nome inclui a operadora")
    void adapterNome() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Cielo"));
        assertTrue(adapter.getNome().contains("Cielo"));
    }

    @Test
    @DisplayName("Adapter: maquininha recusa cobranca acima do limite")
    void adapterRecusa() {
        FormaPagamento adapter = new MaquininhaParceira(new MaquininhaExterna("Stone"));
        assertFalse(adapter.processar(600.0));
    }

    @Test
    @DisplayName("Adapter: maquininha externa retorna a operadora")
    void adapterOperadora() {
        assertEquals("Stone", new MaquininhaExterna("Stone").getOperadora());
    }

}