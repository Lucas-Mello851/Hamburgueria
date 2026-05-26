package br.com.hamburgueria.abstractfactory;

public class BlendGraoDeBico implements Carne {
    @Override
    public String getDescricao() { return "Blend Grao-de-Bico 150g"; }
    @Override
    public double getPeso() { return 150; }
}
