package br.com.hamburgueria.factory;

import br.com.hamburgueria.abstractfactory.IngredientesClassicoFactory;
import br.com.hamburgueria.abstractfactory.IngredientesFactory;
import br.com.hamburgueria.component.Lanche;
import br.com.hamburgueria.concretecomponent.HamburguerClassico;

public class ClassicoFactory implements LancheFactory {

    private final IngredientesFactory ingredientesFactory = new IngredientesClassicoFactory();

    @Override
    public Lanche criar() {
        return new HamburguerClassico(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
