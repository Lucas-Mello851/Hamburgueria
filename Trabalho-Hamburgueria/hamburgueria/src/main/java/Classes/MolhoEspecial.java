package Classes;

import Classes.Lanche;
import Classes.AdicionalDecorator;

public class MolhoEspecial extends AdicionalDecorator {
    public MolhoEspecial(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Molho Especial"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 2.00; }
}
