package br.com.hamburgueria.abstractfactory;

public class IngredientesClassicoFactory implements IngredientesFactory {
    @Override
    public Pao criarPao() { return new PaoBrioche(); }
    @Override
    public Carne criarCarne() { return new BlendBovino(); }
    @Override
    public Molho criarMolho() { return new MaioneseCaseira(); }
}
