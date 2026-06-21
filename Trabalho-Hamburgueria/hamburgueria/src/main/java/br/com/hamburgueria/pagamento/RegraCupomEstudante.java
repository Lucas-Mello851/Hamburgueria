package br.com.hamburgueria.pagamento;

public class RegraCupomEstudante implements RegraCupom {
    @Override
    public PoliticaDesconto interpretar(String token) {
        return token.equalsIgnoreCase("ESTUDANTE") ? new DescontoEstudante() : null;
    }
}

