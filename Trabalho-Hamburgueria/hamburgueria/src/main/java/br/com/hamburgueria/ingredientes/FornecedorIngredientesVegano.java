package br.com.hamburgueria.ingredientes;

public class FornecedorIngredientesVegano implements FornecedorIngredientes {
    @Override
    public Pao criarPao() { return new PaoIntegral(); }
    @Override
    public Carne criarCarne() { return new BlendGraoDeBico(); }
    @Override
    public Molho criarMolho() { return new MolhoVegano(); }
}
