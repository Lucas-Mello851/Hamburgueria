package br.com.hamburgueria.cardapio;



public interface PercursoCardapio {
    boolean temProximo();
    ItemCardapio proximo();
    void reiniciar();
}
