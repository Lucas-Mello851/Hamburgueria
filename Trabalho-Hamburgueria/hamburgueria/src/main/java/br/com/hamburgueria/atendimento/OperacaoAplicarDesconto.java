package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pagamento.PoliticaDesconto;



public class OperacaoAplicarDesconto implements OperacaoCaixa {

    private CalculadoraDesconto calculadora;
    private PoliticaDesconto novoDesconto;
    private PoliticaDesconto descontoAnterior;

    public OperacaoAplicarDesconto(CalculadoraDesconto calculadora, PoliticaDesconto novoDesconto) {
        this.calculadora = calculadora;
        this.novoDesconto = novoDesconto;
    }

    @Override
    public void executar() {
        descontoAnterior = new DescontoPadrao();
        calculadora.setStrategy(novoDesconto);
    }

    @Override
    public void desfazer() {
        calculadora.setStrategy(descontoAnterior);
    }
}
