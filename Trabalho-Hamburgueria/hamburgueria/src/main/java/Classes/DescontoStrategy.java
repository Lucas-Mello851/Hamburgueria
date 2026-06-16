package Classes;

public interface DescontoStrategy {
    double calcular(double precoOriginal);
    String getDescricao();
}
