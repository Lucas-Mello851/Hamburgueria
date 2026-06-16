package Classes;

import Classes.CardapioVisitor;

public class ItemSimples implements ItemCardapio {

    private final String nome;
    private final double preco;

    public ItemSimples(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    @Override
    public void exibir(String indent) {
        System.out.printf("%s- %s: R$ %.2f%n", indent, nome, preco);
    }

    @Override
    public void aceitar(CardapioVisitor visitor) {
        visitor.visitarItemSimples(this);
    }
}
