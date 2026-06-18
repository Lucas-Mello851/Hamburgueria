package br.com.hamburgueria.cardapio;


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
    public String descrever(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s[Combo] %s: R$ %.2f", indent, nome, getPreco()));
        for (ItemCardapio item : itens) {
            sb.append("\n").append(item.descrever(indent + "  "));
        }
        return sb.toString();
    }

    @Override
    public void aceitar(AnalisadorCardapio visitor) {
        visitor.visitarCombo(this);
        for (ItemCardapio item : itens) {
            item.aceitar(visitor);
        }
    }
}
