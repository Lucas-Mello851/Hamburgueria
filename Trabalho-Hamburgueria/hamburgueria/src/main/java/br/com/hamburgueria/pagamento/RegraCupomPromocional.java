package br.com.hamburgueria.pagamento;

public class RegraCupomPromocional implements RegraCupom {
    @Override
    public PoliticaDesconto interpretar(String token) {
        String t = token.toUpperCase();
        if (t.startsWith("PROMO")) {
            try {
                double percentual = Double.parseDouble(t.substring(5));
                if (percentual > 0 && percentual < 100) {
                    return new DescontoPromocao(percentual);
                }
            } catch (NumberFormatException ignored) {
                return null;
            }
        }
        return null;
    }
}

