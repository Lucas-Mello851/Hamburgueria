package br.com.hamburgueria.ingredientes;

public class IngredienteCompartilhadoImpl implements IngredienteCompartilhado {

    private final String descricao;
    private final String tipo;

    public IngredienteCompartilhadoImpl(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public String getTipo() { return tipo; }
}
