package br.com.hamburgueria.abstractfactory;

public class IngredientesVeganoFactory implements IngredientesFactory {
    @Override
    public Pao criarPao() { return new PaoIntegral(); }
    @Override
    public Carne criarCarne() { return new BlendGraoDeBico(); }
    @Override
    public Molho criarMolho() { return new MolhoVegano(); }
}
