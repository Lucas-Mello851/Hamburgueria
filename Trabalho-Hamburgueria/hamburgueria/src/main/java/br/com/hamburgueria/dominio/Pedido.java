package br.com.hamburgueria.dominio;

import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pagamento.PoliticaDesconto;
import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pedidos.CicloPedido;

public class Pedido {

    private final Lanche lanche;
    private final FichaTecnica fichaTecnica;
    private final CicloPedido ciclo;
    private final CalculadoraDesconto calculadora;

    private FormaPagamento formaPagamento;
    private boolean pago;

    public Pedido(Lanche lanche, FichaTecnica fichaTecnica) {
        this(lanche, fichaTecnica, new DescontoPadrao());
    }

    public Pedido(Lanche lanche, FichaTecnica fichaTecnica, PoliticaDesconto desconto) {
        if (lanche == null) {
            throw new IllegalArgumentException("Pedido exige um lanche.");
        }
        this.lanche = lanche;
        this.fichaTecnica = fichaTecnica;
        this.ciclo = new CicloPedido();
        this.calculadora = new CalculadoraDesconto(desconto);
        this.pago = false;
        if (fichaTecnica != null) {
            fichaTecnica.associarLanche(lanche);
        }
    }

    public void aplicarDesconto(PoliticaDesconto desconto) {
        this.calculadora.setStrategy(desconto);
    }

    public double getTotal() {
        return calculadora.calcularPrecoFinal(lanche.getPreco());
    }

    public String getDescricaoDesconto() {
        return calculadora.getDescricaoDesconto();
    }

    public boolean pagar(FormaPagamento forma) {
        this.formaPagamento = forma;
        this.pago = forma.processar(getTotal());
        if (pago) {
            ciclo.confirmar();
        }
        return pago;
    }

    public void marcarPronto() {
        ciclo.preparar();
    }

    public void marcarEntregue() {
        ciclo.entregar();
    }

    public void cancelar() {
        ciclo.cancelar();
    }

    public String descrever() {
        StringBuilder sb = new StringBuilder();
        sb.append(lanche.getDescricao());
        sb.append(" | Total: R$ ").append(String.format("%.2f", getTotal()));
        if (formaPagamento != null) {
            sb.append(" | Pagamento: ").append(formaPagamento.getNome());
        }
        sb.append(" | Status: ").append(ciclo.getStatus());
        if (fichaTecnica != null) {
            sb.append(" | Ingredientes: ").append(fichaTecnica.getTotalIngredientes());
        }
        return sb.toString();
    }

    public Lanche getLanche() { return lanche; }
    public FichaTecnica getFichaTecnica() { return fichaTecnica; }
    public CicloPedido getCiclo() { return ciclo; }
    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public boolean isPago() { return pago; }
    public String getStatus() { return ciclo.getStatus(); }
}

