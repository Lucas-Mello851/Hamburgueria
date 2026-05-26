package br.com.hamburgueria.factory;

import br.com.hamburgueria.abstractfactory.IngredientesFactory;
import br.com.hamburgueria.abstractfactory.IngredientesVeganoFactory;
import br.com.hamburgueria.component.Lanche;
import br.com.hamburgueria.concretecomponent.HamburguerVegano;

public class VeganoFactory implements LancheFactory {

    private final IngredientesFactory ingredientesFactory = new IngredientesVeganoFactory();

    @Override
    public Lanche criar() {
        return new HamburguerVegano(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
