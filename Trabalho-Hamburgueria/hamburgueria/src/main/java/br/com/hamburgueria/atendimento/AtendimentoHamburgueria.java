package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.CriadorBebida;
import br.com.hamburgueria.cardapio.CriadorRefrigerante;
import br.com.hamburgueria.cardapio.CriadorSuco;
import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.ingredientes.ContadorIngredientesPorTipo;
import br.com.hamburgueria.ingredientes.ResumoFichaTextual;
import br.com.hamburgueria.pagamento.InterpretadorCupom;
import br.com.hamburgueria.pagamento.CatalogoPagamentos;
import br.com.hamburgueria.ingredientes.CatalogoIngredientes;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.dominio.ProcessoCheckout;
import br.com.hamburgueria.dominio.CheckoutBalcao;
import br.com.hamburgueria.pagamento.PedidoEntrega;
import br.com.hamburgueria.dominio.CheckoutBalcao;
import br.com.hamburgueria.dominio.CheckoutDelivery;
import br.com.hamburgueria.cardapio.AnalisadorPorPreco;
import br.com.hamburgueria.cardapio.AnalisadorResumo;
import br.com.hamburgueria.cardapio.CardapioComCombos;
import br.com.hamburgueria.cardapio.Combo;
import br.com.hamburgueria.cardapio.GerenciadorCardapio;
import br.com.hamburgueria.cardapio.GerenciadorCardapioProtegido;
import br.com.hamburgueria.cardapio.ItemCardapio;
import br.com.hamburgueria.cardapio.NivelAcesso;
import br.com.hamburgueria.cardapio.PercursoCardapio;
import br.com.hamburgueria.cardapio.PercursoItensPorTipo;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoEstudante;
import br.com.hamburgueria.pagamento.DescontoFidelidade;
import br.com.hamburgueria.pagamento.DescontoPromocao;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pagamento.MaquininhaExterna;
import br.com.hamburgueria.pagamento.MaquininhaParceira;
import br.com.hamburgueria.pagamento.PagamentoCartao;
import br.com.hamburgueria.pagamento.PagamentoDinheiro;
import br.com.hamburgueria.pagamento.PagamentoPix;
import br.com.hamburgueria.pagamento.PedidoBalcao;
import br.com.hamburgueria.pagamento.PedidoDelivery;
import br.com.hamburgueria.pagamento.PoliticaDesconto;
import br.com.hamburgueria.pedidos.CatalogoFavoritos;
import br.com.hamburgueria.pedidos.CicloPedido;
import br.com.hamburgueria.pedidos.HistoricoMontagem;
import br.com.hamburgueria.pedidos.LeitorPedidoTexto;
import br.com.hamburgueria.pedidos.PedidoEmMontagem;
import br.com.hamburgueria.pedidos.PedidoFavorito;
import br.com.hamburgueria.pedidos.PedidoTextoLido;
import br.com.hamburgueria.pedidos.RegistroMontagem;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.produtos.MolhoEspecial;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;

import java.util.List;

public class AtendimentoHamburgueria {

    private Cardapio cardapio;
    private LeitorPedidoTexto interpreter;
    private CatalogoFavoritos registroDeFavoritos;
    private TotemAutoatendimento totem;
    private FilaDePedidos filaPedidos;
    private PainelDeChamada painelDeChamada;
    private final InterpretadorCupom interpretadorCupom = new InterpretadorCupom();
    private final CatalogoPagamentos catalogoPagamentos = new CatalogoPagamentos();
    private final CatalogoReceitas catalogoReceitas = new CatalogoReceitas();
    private final CatalogoIngredientes catalogoIngredientes = new CatalogoIngredientes();
    private final ProcessoCheckout checkoutBalcao = new CheckoutBalcao();
    private PedidoEntrega ultimoPedidoEntrega;

    public AtendimentoHamburgueria() {
        cardapio = Cardapio.getInstance();
        interpreter = new LeitorPedidoTexto();
        registroDeFavoritos = new CatalogoFavoritos();
        totem = new TotemAutoatendimento();

        filaPedidos = totem.getFilaPedidos();
        painelDeChamada = new PainelDeChamada();
        filaPedidos.adicionarObserver(painelDeChamada);
    }

    public Lanche pedirLancheSimples(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        return lanche;
    }

    public Lanche pedirLancheComQueijo(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        Lanche lancheComQueijo = new Queijo(lanche);
        return lancheComQueijo;
    }

    public Lanche pedirLancheComBacon(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        Lanche lancheComBacon = new Bacon(lanche);
        return lancheComBacon;
    }

    public Lanche pedirLancheCompleto(String tipo) {
        Lanche lanche = cardapio.getFabrica(tipo).criar();
        lanche = new Queijo(lanche);
        lanche = new Bacon(lanche);
        lanche = new Alface(lanche);
        lanche = new Tomate(lanche);
        lanche = new MolhoEspecial(lanche);
        return lanche;
    }

    public String descreverCardapio() {
        return cardapio.descreverCardapio();
    }

    public boolean finalizarPedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        PedidoBalcao pedido = new PedidoBalcao(descricao, total, formaPagamento);
        this.ultimoPedidoEntrega = pedido;
        return pedido.finalizar();
    }

    public boolean finalizarPedidoDelivery(String descricao, double total, String endereco, FormaPagamento formaPagamento) {
        PedidoDelivery pedido = new PedidoDelivery(descricao, total, endereco, formaPagamento);
        this.ultimoPedidoEntrega = pedido;
        return pedido.finalizar();
    }

    public PedidoEntrega getUltimoPedidoEntrega() {
        return ultimoPedidoEntrega;
    }

    public ProcessoCheckout getCheckoutBalcao() {
        return checkoutBalcao;
    }

    public PedidoTextoLido pedirPorTexto(String texto) {
        return interpreter.interpretar(texto);
    }

    public PedidoEmMontagem iniciarMontagem(String tipoLanche) {
        PedidoEmMontagem montagem = new PedidoEmMontagem();
        montagem.setTipoLanche(tipoLanche);
        return montagem;
    }

    public void salvarEstadoMontagem(PedidoEmMontagem montagem, HistoricoMontagem historico) {
        historico.salvar(montagem.salvarEstado());
    }

    public void desfazerMontagem(PedidoEmMontagem montagem, HistoricoMontagem historico) {
        RegistroMontagem estado = historico.desfazer();
        montagem.restaurarEstado(estado);
    }

    public void salvarFavorito(String nome, PedidoFavorito favorito) {
        registroDeFavoritos.salvar(nome, favorito);
    }

    public PedidoFavorito pedirFavorito(String nome) {
        return registroDeFavoritos.clonar(nome);
    }

    public boolean contemFavorito(String nome) {
        return registroDeFavoritos.contemFavorito(nome);
    }

    public List<String> obterEtapasPreparo(String tipo) {
        ReceitaLanche preparo;
        if ("Smash".equals(tipo)) {
            preparo = new ReceitaSmash();
        } else if ("Vegano".equals(tipo)) {
            preparo = new ReceitaVegano();
        } else {
            preparo = new ReceitaClassico();
        }
        return preparo.preparar();
    }

    public CicloPedido atenderPorTexto(String texto) {
        totem.interpretarPedido(texto);
        totem.montarLanche();
        totem.montarFichaTecnica();
        if (!totem.validarPedido()) {
            throw new IllegalStateException("Pedido invalido: nao passou na validacao.");
        }

        CicloPedido ciclo = totem.registrarPedido();
        return ciclo;
    }

    public void anunciarPedidoPronto(String descricao) {
        filaPedidos.pedidoPronto(descricao);
    }

    public NotificacaoCliente registrarClienteParaNotificacao(String nomeCliente) {
        NotificacaoCliente notificacao = new NotificacaoCliente(nomeCliente);
        filaPedidos.adicionarObserver(notificacao);
        return notificacao;
    }

    public PainelDeChamada getPainelDeChamada() {
        return painelDeChamada;
    }

    public FilaDePedidos getFilaPedidos() {
        return filaPedidos;
    }

    public Lanche montarLanchePorTexto(String texto) {
        totem.interpretarPedido(texto);
        return totem.montarLanche();
    }

    public FichaTecnica obterFichaTecnica(String texto) {
        totem.interpretarPedido(texto);
        totem.montarLanche();
        return totem.montarFichaTecnica();
    }

    public double calcularTotalComDesconto(String texto, PoliticaDesconto desconto) {
        totem.interpretarPedido(texto);
        totem.montarLanche();
        return totem.calcularTotal(desconto);
    }

    public double calcularComDescontoEstudante(String texto) {
        return calcularTotalComDesconto(texto, new DescontoEstudante());
    }

    public double calcularComDescontoFidelidade(String texto) {
        return calcularTotalComDesconto(texto, new DescontoFidelidade());
    }

    public double calcularComPromocao(String texto, double percentual) {
        return calcularTotalComDesconto(texto, new DescontoPromocao(percentual));
    }

    public boolean pagarComPix(String descricao, double total) {
        return finalizarPedidoBalcao(descricao, total, new PagamentoPix());
    }

    public boolean pagarComCartao(String descricao, double total, String tipoCartao) {
        return finalizarPedidoBalcao(descricao, total, new PagamentoCartao(tipoCartao));
    }

    public boolean pagarComDinheiro(String descricao, double total) {
        return finalizarPedidoBalcao(descricao, total, new PagamentoDinheiro());
    }

    public boolean pagarComMaquininhaParceira(String descricao, double total, String operadora) {
        FormaPagamento adaptada = new MaquininhaParceira(new MaquininhaExterna(operadora));
        return finalizarPedidoBalcao(descricao, total, adaptada);
    }

    public void aplicarDescontoNoCaixa(PoliticaDesconto desconto) {
        CalculadoraDesconto calc = new CalculadoraDesconto(desconto);
        OperadorCaixa caixa = totem.getOperadorCaixa();
        caixa.executar(new OperacaoAplicarDesconto(calc, desconto));
    }

    public void cancelarPedidoNoCaixa(CicloPedido ciclo) {
        OperadorCaixa caixa = totem.getOperadorCaixa();
        caixa.executar(new OperacaoCancelarPedido(ciclo));
    }

    public boolean desfazerUltimaOperacaoCaixa() {
        return totem.getOperadorCaixa().desfazerUltimo();
    }

    public List<String> filtrarItensAtePreco(double precoMaximo) {
        AnalisadorPorPreco filtro = new AnalisadorPorPreco(precoMaximo);
        for (Combo combo : CardapioComCombos.getInstance().getCombos().values()) {
            combo.aceitar(filtro);
        }
        return filtro.getItensFiltrados();
    }

    public List<String> resumirCardapio() {
        AnalisadorResumo resumo = new AnalisadorResumo();
        for (Combo combo : CardapioComCombos.getInstance().getCombos().values()) {
            combo.aceitar(resumo);
        }
        return resumo.getLinhas();
    }

    public List<String> listarItensDoTipo(Class<? extends ItemCardapio> tipo) {
        List<Combo> combos =
                new java.util.ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        PercursoCardapio it = new PercursoItensPorTipo(combos, tipo);
        List<String> nomes = new java.util.ArrayList<>();
        while (it.temProximo()) {
            ItemCardapio item = it.proximo();
            nomes.add(item.descrever(""));
        }
        return nomes;
    }

    public GerenciadorCardapio gerenciarCardapioComo(NivelAcesso nivel) {
        return new GerenciadorCardapioProtegido(nivel);
    }

    public Pedido montarPedidoCompleto(String texto, PoliticaDesconto desconto) {
        totem.interpretarPedido(texto);
        Lanche lanche = totem.montarLanche();
        FichaTecnica ficha = totem.montarFichaTecnica();
        return new Pedido(lanche, ficha, desconto);
    }

    public Pedido realizarPedido(String texto, PoliticaDesconto desconto, FormaPagamento forma) {
        Pedido pedido = montarPedidoCompleto(texto, desconto);
        boolean pago = pedido.pagar(forma);
        if (pago) {
            totem.getFilaPedidos().novoPedido(pedido.getLanche().getDescricao());
            totem.getCozinha().receberPedido(pedido);
        }
        return pedido;
    }

    public ProcessoCheckout.ResultadoCheckout finalizarNoBalcao(
            String texto, PoliticaDesconto desconto, FormaPagamento forma) {
        Pedido pedido = montarPedidoCompleto(texto, desconto);
        ProcessoCheckout checkout = new CheckoutBalcao();
        ProcessoCheckout.ResultadoCheckout r = checkout.finalizar(pedido, forma);
        if (r.isAprovado()) {
            totem.getFilaPedidos().novoPedido(pedido.getLanche().getDescricao());
        }
        return r;
    }

    public ProcessoCheckout.ResultadoCheckout finalizarNoDelivery(
            String texto, PoliticaDesconto desconto, FormaPagamento forma, String endereco) {
        Pedido pedido = montarPedidoCompleto(texto, desconto);
        ProcessoCheckout checkout = new CheckoutDelivery(endereco);
        ProcessoCheckout.ResultadoCheckout r = checkout.finalizar(pedido, forma);
        if (r.isAprovado()) {
            totem.getFilaPedidos().novoPedido(pedido.getLanche().getDescricao());
        }
        return r;
    }

    public TotemAutoatendimento getTotem() {
        return totem;
    }

    public Bebida pedirBebida(CriadorBebida criador) {
        return criador.criar();
    }

    public Bebida pedirRefrigerante() {
        return pedirBebida(new CriadorRefrigerante());
    }

    public Bebida pedirSuco() {
        return pedirBebida(new CriadorSuco());
    }

    public ContadorIngredientesPorTipo analisarIngredientesPorTipo(String texto) {
        totem.interpretarPedido(texto);
        totem.montarLanche();
        FichaTecnica ficha = totem.montarFichaTecnica();
        ContadorIngredientesPorTipo contador = new ContadorIngredientesPorTipo();
        ficha.aceitar(contador);
        return contador;
    }

    public ResumoFichaTextual resumirFichaTecnica(String texto) {
        totem.interpretarPedido(texto);
        totem.montarLanche();
        FichaTecnica ficha = totem.montarFichaTecnica();
        ResumoFichaTextual resumo = new ResumoFichaTextual();
        ficha.aceitar(resumo);
        return resumo;
    }

    public PoliticaDesconto interpretarCupom(String cupom) {
        return interpretadorCupom.interpretar(cupom);
    }

    public double calcularComCupom(String texto, String cupom) {
        PoliticaDesconto desconto = interpretarCupom(cupom);
        return calcularTotalComDesconto(texto, desconto);
    }

    public FormaPagamento formaDePagamento(String chave) {
        return catalogoPagamentos.obter(chave);
    }

    public br.com.hamburgueria.pagamento.ReciboPagamento emitirRecibo(
            String tipoLanche, FormaPagamento forma, double valor) {
        br.com.hamburgueria.pedidos.PedidoMontado montado =
                new br.com.hamburgueria.pedidos.MontadorPedido()
                        .setTipoLanche(tipoLanche)
                        .setFormaPagamento(forma.getNome())
                        .build();
        return new br.com.hamburgueria.pagamento.ReciboPagamento(montado, forma, valor);
    }

    public int totalFormasPagamento() {
        return catalogoPagamentos.getTotalFormas();
    }

    public java.util.List<String> etapasDaReceita(String tipo) {
        return catalogoReceitas.etapasDe(tipo);
    }

    public int totalReceitas() {
        return catalogoReceitas.getTotalReceitas();
    }

    public java.util.List<String> ingredientesDisponiveis() {
        return catalogoIngredientes.listarDescricoes();
    }

    public int totalIngredientesCatalogo() {
        return catalogoIngredientes.getTotalIngredientes();
    }
}

