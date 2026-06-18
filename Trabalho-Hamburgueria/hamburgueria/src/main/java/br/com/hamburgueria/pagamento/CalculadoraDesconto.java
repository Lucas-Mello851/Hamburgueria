package br.com.hamburgueria.pagamento;

public class CalculadoraDesconto {

    private PoliticaDesconto strategy;

    public CalculadoraDesconto(PoliticaDesconto strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PoliticaDesconto strategy) {
        this.strategy = strategy;
    }

    public double calcularPrecoFinal(double precoOriginal) {
        double precoComDesconto = strategy.calcular(precoOriginal);
        return precoComDesconto;
    }

    public String getDescricaoDesconto() {
        String descricao = strategy.getDescricao();
        return descricao;
    }
}
