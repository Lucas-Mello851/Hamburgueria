package br.com.hamburgueria.cardapio;

public interface GerenciadorCardapio {
    boolean adicionarItem(String nome, double preco);
    boolean removerItem(String nome);
    boolean alterarPreco(String nome, double novoPreco);
    boolean contemItem(String nome);
    int getTotalItens();
}
