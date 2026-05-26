package br.com.hamburgueria.abstractfactory;

public class BlendBovino implements Carne {
    @Override
    public String getDescricao() { return "Blend Bovino 160g"; }
    @Override
    public double getPeso() { return 160; }
}
