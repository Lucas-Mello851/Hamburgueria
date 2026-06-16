package Classes;

import Classes.CardapioVisitor;

public interface ItemCardapio {
    String getNome();
    double getPreco();
    void exibir(String indent);
    void aceitar(CardapioVisitor visitor);
}
