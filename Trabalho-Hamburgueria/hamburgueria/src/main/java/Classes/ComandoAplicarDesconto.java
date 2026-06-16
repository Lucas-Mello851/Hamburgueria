package Classes;

public class ComandoAplicarDesconto implements Comando {

    private final CalculadoraPreco calculadora;
    private final DescontoStrategy novoDesconto;
    private DescontoStrategy descontoAnterior;

    public ComandoAplicarDesconto(CalculadoraPreco calculadora, DescontoStrategy novoDesconto) {
        this.calculadora = calculadora;
        this.novoDesconto = novoDesconto;
    }

    @Override
    public void executar() {
        descontoAnterior = calculadora.getStrategy();
        calculadora.setStrategy(novoDesconto);
        System.out.println("Desconto aplicado: " + novoDesconto.getDescricao());
    }

    @Override
    public void desfazer() {
        calculadora.setStrategy(descontoAnterior);
        System.out.println("Desconto removido. Voltando para: " + descontoAnterior.getDescricao());
    }
}
