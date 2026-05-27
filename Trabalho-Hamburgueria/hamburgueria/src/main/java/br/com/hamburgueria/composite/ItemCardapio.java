package br.com.hamburgueria.composite;

import br.com.hamburgueria.visitor.CardapioVisitor;

public interface ItemCardapio {
    String getNome();
    double getPreco();
    void exibir(String indent);
    void aceitar(CardapioVisitor visitor);
}
