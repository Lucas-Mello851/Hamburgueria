package Classes;

import Classes.Lanche;
import Classes.AdicionalDecorator;

public class Alface extends AdicionalDecorator {
    public Alface(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Alface"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 1.00; }
}
