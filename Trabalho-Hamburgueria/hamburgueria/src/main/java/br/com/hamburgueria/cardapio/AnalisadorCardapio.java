package br.com.hamburgueria.cardapio;



public interface AnalisadorCardapio {
    void visitarItemSimples(ItemSimples item);
    void visitarCombo(Combo combo);
}
