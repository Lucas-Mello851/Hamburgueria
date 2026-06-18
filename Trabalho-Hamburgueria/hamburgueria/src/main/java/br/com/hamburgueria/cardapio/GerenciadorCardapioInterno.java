package br.com.hamburgueria.cardapio;


import java.util.LinkedHashMap;
import java.util.Map;

public class GerenciadorCardapioInterno implements GerenciadorCardapio {

    private Map<String, Double> itensGerenciados = new LinkedHashMap<>();

    public GerenciadorCardapioInterno() {
        Cardapio cardapio = Cardapio.getInstance();
        cardapio.getAdicionais().forEach((nome, preco) -> itensGerenciados.put(nome, preco));
    }

    @Override
    public boolean adicionarItem(String nome, double preco) {
        itensGerenciados.put(nome, preco);
        return true;
    }

    @Override
    public boolean removerItem(String nome) {
        return itensGerenciados.remove(nome) != null;
    }

    @Override
    public boolean alterarPreco(String nome, double novoPreco) {
        if (itensGerenciados.containsKey(nome)) {
            itensGerenciados.put(nome, novoPreco);
            return true;
        }
        return false;
    }

    @Override
    public boolean contemItem(String nome) {
        return itensGerenciados.containsKey(nome);
    }

    @Override
    public int getTotalItens() {
        return itensGerenciados.size();
    }
}
