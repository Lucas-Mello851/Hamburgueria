package Classes;

import Classes.Lanche;
import Classes.AdicionalDecorator;

public class Tomate extends AdicionalDecorator {
    public Tomate(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Tomate"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 1.00; }
}
