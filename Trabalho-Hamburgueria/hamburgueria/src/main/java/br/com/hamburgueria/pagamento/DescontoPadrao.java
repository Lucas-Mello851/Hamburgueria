package br.com.hamburgueria.pagamento;

public class DescontoPadrao implements PoliticaDesconto {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal;
    }

    @Override
    public String getDescricao() {
        return "Sem desconto";
    }
}
