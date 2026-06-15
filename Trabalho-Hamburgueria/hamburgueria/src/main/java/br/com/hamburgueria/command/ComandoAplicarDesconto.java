package br.com.hamburgueria.command;

import br.com.hamburgueria.strategy.CalculadoraPreco;
import br.com.hamburgueria.strategy.DescontoStrategy;
import br.com.hamburgueria.strategy.SemDesconto;

public class ComandoAplicarDesconto implements Comando {

    private CalculadoraPreco calculadora;
    private DescontoStrategy novoDesconto;
    private DescontoStrategy descontoAnterior;

    public ComandoAplicarDesconto(CalculadoraPreco calculadora, DescontoStrategy novoDesconto) {
        this.calculadora = calculadora;
        this.novoDesconto = novoDesconto;
    }

    @Override
    public void executar() {
        descontoAnterior = new SemDesconto();
        calculadora.setStrategy(novoDesconto);
        System.out.println("Desconto aplicado: " + novoDesconto.getDescricao());
    }

    @Override
    public void desfazer() {
        calculadora.setStrategy(descontoAnterior);
        System.out.println("Desconto removido. Voltando para: " + descontoAnterior.getDescricao());
    }
}
