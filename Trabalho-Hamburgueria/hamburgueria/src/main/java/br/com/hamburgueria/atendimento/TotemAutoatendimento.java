package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.pedidos.CicloPedido;
import br.com.hamburgueria.pedidos.LeitorPedidoTexto;
import br.com.hamburgueria.pedidos.PedidoTextoLido;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.produtos.MolhoEspecial;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;
import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pagamento.PoliticaDesconto;

public class TotemAutoatendimento {

    private final Cardapio cardapio;
    private final LeitorPedidoTexto interpreter;
    private final OperadorCaixa operadorCaixa;
    private final CalculadoraDesconto calculadoraDesconto;

    private final PostoCaixa postoCaixa;
    private final Cozinha cozinha;
    private final Entregador entregador;
    private final CentralAtendimento central;
    private final FilaDePedidos filaPedidos;
    private final MonitorCozinha monitorCozinha;
    private final MonitorCaixa monitorCaixa;

    private PedidoTextoLido pedidoInterpretado;
    private Lanche lancheMontado;
    private FichaTecnica fichaTecnica;
    private CicloPedido cicloPedido;
    private boolean pedidoValidado;
    private EtapaValidacao cadeiaValidacao;
    private SolicitacaoPedido solicitacaoAtual;

    public TotemAutoatendimento() {
        this.cardapio = Cardapio.getInstance();
        this.interpreter = new LeitorPedidoTexto();
        this.operadorCaixa = new OperadorCaixa();
        this.calculadoraDesconto = new CalculadoraDesconto(new DescontoPadrao());

        this.postoCaixa = new PostoCaixa();
        this.cozinha = new Cozinha();
        this.entregador = new Entregador();
        this.filaPedidos = new FilaDePedidos();
        CentralAtendimentoRestaurante restaurante =
                new CentralAtendimentoRestaurante(cozinha, postoCaixa, entregador);
        restaurante.setFilaPedidos(filaPedidos);
        this.central = restaurante;

        this.monitorCozinha = new MonitorCozinha();
        this.monitorCaixa = new MonitorCaixa();
        filaPedidos.adicionarObserver(monitorCozinha);
        filaPedidos.adicionarObserver(monitorCaixa);
    }

    public PedidoTextoLido interpretarPedido(String texto) {
        this.pedidoInterpretado = interpreter.interpretar(texto);
        return pedidoInterpretado;
    }

    public Lanche montarLanche() {
        if (pedidoInterpretado == null) {
            throw new IllegalStateException("Interprete o pedido antes de montar o lanche.");
        }
        String tipo = pedidoInterpretado.getTipoLanche();
        Lanche lanche = cardapio.getFabrica(tipo).criar();

        for (String adicional : pedidoInterpretado.getAdicionais()) {
            lanche = aplicarAdicional(lanche, adicional);
        }
        this.lancheMontado = lanche;
        return lanche;
    }

    private Lanche aplicarAdicional(Lanche lanche, String adicional) {
        if (adicional.contains("Queijo")) return new Queijo(lanche);
        if (adicional.contains("Bacon"))  return new Bacon(lanche);
        if (adicional.contains("Alface")) return new Alface(lanche);
        if (adicional.contains("Tomate")) return new Tomate(lanche);
        if (adicional.contains("Molho"))  return new MolhoEspecial(lanche);
        return lanche;
    }

    public FichaTecnica montarFichaTecnica() {
        if (pedidoInterpretado == null) {
            throw new IllegalStateException("Interprete o pedido antes da ficha tecnica.");
        }
        String tipo = pedidoInterpretado.getTipoLanche();
        this.fichaTecnica = FichaTecnica.montar(
                tipo, cardapio.getFornecedorIngredientes(tipo), 1, 1, 1);
        return fichaTecnica;
    }

    public boolean validarPedido() {
        if (lancheMontado == null) {
            throw new IllegalStateException("Monte o lanche antes de validar.");
        }
        this.cadeiaValidacao = new ValidacaoEstoque();
        EtapaValidacao pagamento = new ValidacaoPagamento();
        EtapaValidacao processador = new FinalizacaoPedido();
        cadeiaValidacao.setProximo(pagamento).setProximo(processador);

        this.solicitacaoAtual = new SolicitacaoPedido(
                pedidoInterpretado.getTipoLanche(), lancheMontado.getPreco());
        cadeiaValidacao.processar(solicitacaoAtual);

        this.pedidoValidado = solicitacaoAtual.isProcessado();
        return pedidoValidado;
    }

    public EtapaValidacao getCadeiaValidacao() {
        return cadeiaValidacao;
    }

    public SolicitacaoPedido getSolicitacaoAtual() {
        return solicitacaoAtual;
    }

    public CicloPedido registrarPedido() {
        if (!pedidoValidado) {
            throw new IllegalStateException("Pedido nao validado. Valide antes de registrar.");
        }
        this.cicloPedido = new CicloPedido();
        OperacaoRegistrarPedido operacao =
                new OperacaoRegistrarPedido(pedidoInterpretado.getTipoLanche(), cicloPedido);
        operadorCaixa.executar(operacao);

        postoCaixa.registrarPedido(pedidoInterpretado.getTipoLanche());
        return cicloPedido;
    }

    public double calcularTotal(PoliticaDesconto desconto) {
        if (lancheMontado == null) {
            throw new IllegalStateException("Monte o lanche antes de calcular o total.");
        }
        calculadoraDesconto.setStrategy(desconto);
        return calculadoraDesconto.calcularPrecoFinal(lancheMontado.getPreco());
    }

    public PedidoTextoLido getPedidoInterpretado() { return pedidoInterpretado; }
    public Lanche getLancheMontado() { return lancheMontado; }
    public FichaTecnica getFichaTecnica() { return fichaTecnica; }
    public CicloPedido getCicloPedido() { return cicloPedido; }
    public OperadorCaixa getOperadorCaixa() { return operadorCaixa; }
    public boolean isPedidoValidado() { return pedidoValidado; }

    public PostoCaixa getPostoCaixa() { return postoCaixa; }
    public Cozinha getCozinha() { return cozinha; }
    public Entregador getEntregador() { return entregador; }
    public CentralAtendimento getCentral() { return central; }
    public FilaDePedidos getFilaPedidos() { return filaPedidos; }
    public MonitorCozinha getMonitorCozinha() { return monitorCozinha; }
    public MonitorCaixa getMonitorCaixa() { return monitorCaixa; }
}

