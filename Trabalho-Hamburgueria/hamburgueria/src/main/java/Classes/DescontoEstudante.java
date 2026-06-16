package Classes;

public class DescontoEstudante implements DescontoStrategy {

    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * 0.85;
    }

    @Override
    public String getDescricao() {
        return "Desconto estudante (15%)";
    }
}
