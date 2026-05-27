package br.com.hamburgueria.flyweight;

public class IngredienteFlyweightImpl implements IngredienteFlyweight {

    private final String descricao;
    private final String tipo;

    public IngredienteFlyweightImpl(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public String getTipo() { return tipo; }
}
