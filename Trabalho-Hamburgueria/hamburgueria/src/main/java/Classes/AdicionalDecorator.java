package Classes;

import Classes.Lanche;

public abstract class AdicionalDecorator implements Lanche {

    protected final Lanche lanche;

    public AdicionalDecorator(Lanche lanche) {
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
