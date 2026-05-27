package br.com.hamburgueria.facade;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.component.Lanche;
import br.com.hamburgueria.concretedecorator.*;

public class HamburgueriafFacade {

    private Cardapio cardapio;

    public HamburgueriafFacade() {
        cardapio = Cardapio.getInstance();
    }

    public Lanche pedirLancheSimples(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        return lanche;
    }

    public Lanche pedirLancheComQueijo(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        Lanche lancheComQueijo = new Queijo(lanche);
        return lancheComQueijo;
    }

    public Lanche pedirLancheComBacon(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        Lanche lancheComBacon = new Bacon(lanche);
        return lancheComBacon;
    }

    public Lanche pedirLancheCompleto(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        lanche = new Queijo(lanche);
        lanche = new Bacon(lanche);
        lanche = new Alface(lanche);
        lanche = new Tomate(lanche);
        lanche = new MolhoEspecial(lanche);
        return lanche;
    }

    public void exibirCardapio() {
        cardapio.exibirCardapio();
    }
}
