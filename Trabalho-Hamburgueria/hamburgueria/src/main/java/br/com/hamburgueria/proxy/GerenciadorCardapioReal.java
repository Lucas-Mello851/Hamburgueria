package br.com.hamburgueria.proxy;

import br.com.hamburgueria.cardapio.Cardapio;

import java.util.LinkedHashMap;
import java.util.Map;

public class GerenciadorCardapioReal implements GerenciadorCardapio {

    private Map<String, Double> itensGerenciados = new LinkedHashMap<>();

    public GerenciadorCardapioReal() {
        Cardapio cardapio = Cardapio.getInstance();
        cardapio.getAdicionais().forEach((nome, preco) -> itensGerenciados.put(nome, preco));
    }

    @Override
    public void adicionarItem(String nome, double preco) {
        itensGerenciados.put(nome, preco);
        System.out.println("Item adicionado ao cardapio: " + nome + " - R$ " + preco);
    }

    @Override
    public void removerItem(String nome) {
        if (itensGerenciados.remove(nome) != null) {
            System.out.println("Item removido do cardapio: " + nome);
        } else {
            System.out.println("Item nao encontrado: " + nome);
        }
    }

    @Override
    public void alterarPreco(String nome, double novoPreco) {
        if (itensGerenciados.containsKey(nome)) {
            itensGerenciados.put(nome, novoPreco);
            System.out.println("Preco alterado: " + nome + " -> R$ " + novoPreco);
        } else {
            System.out.println("Item nao encontrado: " + nome);
        }
    }

    @Override
    public void exibirItensGerenciados() {
        System.out.println("=== ITENS GERENCIADOS ===");
        itensGerenciados.forEach((nome, preco) ->
            System.out.printf("  %-22s R$ %.2f%n", nome, preco));
        System.out.println("=========================");
    }
}
