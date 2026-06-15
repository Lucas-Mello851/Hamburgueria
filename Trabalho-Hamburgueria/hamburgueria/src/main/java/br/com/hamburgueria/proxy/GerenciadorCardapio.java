package br.com.hamburgueria.proxy;

public interface GerenciadorCardapio {
    void adicionarItem(String nome, double preco);
    void removerItem(String nome);
    void alterarPreco(String nome, double novoPreco);
    void exibirItensGerenciados();
}
