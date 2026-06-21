package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.GerenciadorCardapio;
import br.com.hamburgueria.cardapio.GerenciadorCardapioProtegido;
import br.com.hamburgueria.cardapio.NivelAcesso;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorCardapioTest {

    @Test
    void proxyAtendenteNega() {
        GerenciadorCardapio atendente = new GerenciadorCardapioProtegido(NivelAcesso.ATENDENTE);
        assertFalse(atendente.adicionarItem("Onion Rings", 9.0));
    }

    @Test
    void proxyAtendenteNaoAltera() {
        GerenciadorCardapio atendente = new GerenciadorCardapioProtegido(NivelAcesso.ATENDENTE);
        assertFalse(atendente.alterarPreco("Queijo Cheddar", 4.0));
    }

    @Test
    void proxyGerenteAdiciona() {
        GerenciadorCardapio gerente = new GerenciadorCardapioProtegido(NivelAcesso.GERENTE);
        assertTrue(gerente.adicionarItem("Onion Rings", 9.0));
    }

    @Test
    void proxyGerenteContem() {
        GerenciadorCardapio gerente = new GerenciadorCardapioProtegido(NivelAcesso.GERENTE);
        gerente.adicionarItem("Nuggets", 12.0);
        assertTrue(gerente.contemItem("Nuggets"));
    }

    @Test
    void proxyGerenteAltera() {
        GerenciadorCardapio gerente = new GerenciadorCardapioProtegido(NivelAcesso.GERENTE);
        assertTrue(gerente.alterarPreco("Bacon Crocante", 5.0));
    }

}