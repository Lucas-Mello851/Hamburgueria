package Classes;

import Classes.IngredientesFactory;
import Classes.IngredientesVeganoFactory;
import Classes.Lanche;
import Classes.HamburguerVegano;

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
