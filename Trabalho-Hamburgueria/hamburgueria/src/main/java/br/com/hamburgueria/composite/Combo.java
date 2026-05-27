package br.com.hamburgueria.composite;

import br.com.hamburgueria.visitor.CardapioVisitor;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {

    private String nome;
    private List<ItemCardapio> itens;

    public Combo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemCardapio item) {
        itens.add(item);
    }

    public void remover(ItemCardapio item) {
        itens.remove(item);
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (ItemCardapio item : itens) {
            total = total + item.getPreco();
        }
        return total;
    }

    @Override
    public void exibir(String indent) {
        System.out.printf("%s[Combo] %s: R$ %.2f%n", indent, nome, getPreco());
        for (ItemCardapio item : itens) {
            item.exibir(indent + "  ");
        }
    }

    @Override
    public void aceitar(CardapioVisitor visitor) {
        visitor.visitarCombo(this);
        for (ItemCardapio item : itens) {
            item.aceitar(visitor);
        }
    }
}
