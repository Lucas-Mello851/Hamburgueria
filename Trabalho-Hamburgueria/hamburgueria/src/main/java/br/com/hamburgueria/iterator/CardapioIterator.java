package br.com.hamburgueria.iterator;

import br.com.hamburgueria.composite.ItemCardapio;

public interface CardapioIterator {
    boolean temProximo();
    ItemCardapio proximo();
    void reiniciar();
}
