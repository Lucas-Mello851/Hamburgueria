package br.com.hamburgueria.pagamento;

public class RegraCupomFidelidade implements RegraCupom {
    @Override
    public PoliticaDesconto interpretar(String token) {
        return token.equalsIgnoreCase("FIDELIDADE") ? new DescontoFidelidade() : null;
    }
}

