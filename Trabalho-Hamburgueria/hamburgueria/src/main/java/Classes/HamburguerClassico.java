package Classes;

import Classes.Carne;
import Classes.Molho;
import Classes.Pao;
import Classes.Lanche;

public class HamburguerClassico implements Lanche {

    private final Pao pao;
    private final Carne carne;
    private final Molho molho;

    public HamburguerClassico() {
        this.pao = null;
        this.carne = null;
        this.molho = null;
    }

    public HamburguerClassico(Pao pao, Carne carne, Molho molho) {
        this.pao = pao;
        this.carne = carne;
        this.molho = molho;
    }

    @Override
    public String getDescricao() {
        if (pao != null) {
            return "Hamburguer Classico (" + pao.getDescricao() + " + " + carne.getDescricao() + " + " + molho.getDescricao() + ")";
        }
        return "Hambúrguer Clássico (Pão Brioche + Blend 160g)";
    }

    @Override
    public double getPreco() {
        return 22.00;
    }
}
