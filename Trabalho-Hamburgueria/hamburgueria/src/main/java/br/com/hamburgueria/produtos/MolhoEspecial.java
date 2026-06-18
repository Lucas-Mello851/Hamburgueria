package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.ingredientes.Molho;



public class MolhoEspecial extends Adicional {
    public MolhoEspecial(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Molho Especial"; }

    @Override
    public double getPreco() { return lanche.getPreco() + Precos.ADICIONAL_MOLHO_ESPECIAL; }
}
