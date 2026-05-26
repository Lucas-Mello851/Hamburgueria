package br.com.hamburgueria.factory;

import br.com.hamburgueria.abstractfactory.IngredientesFactory;
import br.com.hamburgueria.abstractfactory.IngredientesSmashFactory;
import br.com.hamburgueria.component.Lanche;
import br.com.hamburgueria.concretecomponent.HamburguerSmash;

public class SmashFactory implements LancheFactory {

    private final IngredientesFactory ingredientesFactory = new IngredientesSmashFactory();

    @Override
    public Lanche criar() {
        return new HamburguerSmash(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
