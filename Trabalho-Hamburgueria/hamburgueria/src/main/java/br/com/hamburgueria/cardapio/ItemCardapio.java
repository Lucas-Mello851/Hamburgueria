package br.com.hamburgueria.cardapio;


public interface ItemCardapio {
    String getNome();
    double getPreco();
    String descrever(String indent);
    void aceitar(AnalisadorCardapio visitor);
}
