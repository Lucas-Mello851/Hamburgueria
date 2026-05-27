package br.com.hamburgueria.visitor;

import br.com.hamburgueria.composite.Combo;
import br.com.hamburgueria.composite.ItemSimples;

public interface CardapioVisitor {
    void visitarItemSimples(ItemSimples item);
    void visitarCombo(Combo combo);
}
