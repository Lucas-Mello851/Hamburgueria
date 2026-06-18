package br.com.hamburgueria.produtos;



public abstract class Adicional implements Lanche {

    protected final Lanche lanche;

    public Adicional(Lanche lanche) {
        this.lanche = lanche;
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao();
    }

    @Override
    public double getPreco() {
        return lanche.getPreco();
    }
}
