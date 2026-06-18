package br.com.hamburgueria.ingredientes;

public class FornecedorIngredientesClassico implements FornecedorIngredientes {
    @Override
    public Pao criarPao() { return new PaoBrioche(); }
    @Override
    public Carne criarCarne() { return new BlendBovino(); }
    @Override
    public Molho criarMolho() { return new MaioneseCaseira(); }
}
