package br.com.hamburgueria.dominio;

import br.com.hamburgueria.pagamento.FormaPagamento;

public abstract class ProcessoCheckout {

    public final ResultadoCheckout finalizar(Pedido pedido, FormaPagamento forma) {
        validar(pedido);
        double total = aplicarTaxaDoCanal(pedido.getTotal());
        boolean aprovado = cobrar(pedido, forma);
        String confirmacao = aprovado
                ? confirmar(pedido, total)
                : "Pagamento recusado em " + nomeDoCanal();
        return new ResultadoCheckout(nomeDoCanal(), total, aprovado, confirmacao);
    }

    protected void validar(Pedido pedido) {
        if (pedido == null || pedido.getLanche() == null) {
            throw new IllegalStateException("Pedido invalido para checkout.");
        }
    }

    protected boolean cobrar(Pedido pedido, FormaPagamento forma) {
        return pedido.pagar(forma);
    }

    protected abstract String nomeDoCanal();

    protected abstract double aplicarTaxaDoCanal(double total);

    protected abstract String confirmar(Pedido pedido, double totalFinal);

    public static final class ResultadoCheckout {
        private final String canal;
        private final double totalFinal;
        private final boolean aprovado;
        private final String mensagem;

        public ResultadoCheckout(String canal, double totalFinal, boolean aprovado, String mensagem) {
            this.canal = canal;
            this.totalFinal = totalFinal;
            this.aprovado = aprovado;
            this.mensagem = mensagem;
        }

        public String getCanal() { return canal; }
        public double getTotalFinal() { return totalFinal; }
        public boolean isAprovado() { return aprovado; }
        public String getMensagem() { return mensagem; }
    }
}

