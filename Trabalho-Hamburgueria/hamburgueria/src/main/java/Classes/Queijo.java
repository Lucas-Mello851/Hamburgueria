package Classes;

import Classes.Lanche;
import Classes.AdicionalDecorator;

public class Queijo extends AdicionalDecorator {
    public Queijo(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Queijo Cheddar"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 3.00; }
}
