package br.com.hamburgueria.cardapio;


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
    public String descrever(String indent) {
        return String.format("%s- %s: R$ %.2f", indent, nome, preco);
    }

    @Override
    public void aceitar(AnalisadorCardapio visitor) {
        visitor.visitarItemSimples(this);
    }
}
