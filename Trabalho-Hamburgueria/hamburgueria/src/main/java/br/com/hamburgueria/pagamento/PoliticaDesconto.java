package br.com.hamburgueria.pagamento;

public interface PoliticaDesconto {
    double calcular(double precoOriginal);
    String getDescricao();
}
