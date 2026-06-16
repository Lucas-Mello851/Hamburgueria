package Classes;

public class SemDesconto implements DescontoStrategy {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal;
    }

    @Override
    public String getDescricao() {
        return "Sem desconto";
    }
}
