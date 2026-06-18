package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.ingredientes.Carne;
import br.com.hamburgueria.ingredientes.Molho;
import br.com.hamburgueria.ingredientes.Pao;



public class HamburguerVegano implements Lanche {

    private final Pao pao;
    private final Carne carne;
    private final Molho molho;

    public HamburguerVegano() {
        this.pao = null;
        this.carne = null;
        this.molho = null;
    }

    public HamburguerVegano(Pao pao, Carne carne, Molho molho) {
        this.pao = pao;
        this.carne = carne;
        this.molho = molho;
    }

    @Override
    public String getDescricao() {
        if (pao != null) {
            return "Hamburguer Vegano (" + pao.getDescricao() + " + " + carne.getDescricao() + " + " + molho.getDescricao() + ")";
        }
        return "Hambúrguer Vegano (Pão Integral + Blend Grão-de-Bico)";
    }

    @Override
    public double getPreco() {
        return Precos.HAMBURGUER_VEGANO;
    }
}
