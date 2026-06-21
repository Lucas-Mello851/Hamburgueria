package br.com.hamburgueria.loja;

import br.com.hamburgueria.atendimento.AtendimentoHamburgueria;
import br.com.hamburgueria.atendimento.TotemAutoatendimento;
import br.com.hamburgueria.atendimento.CatalogoReceitas;
import br.com.hamburgueria.atendimento.ReceitaLanche;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.CardapioComCombos;
import br.com.hamburgueria.cardapio.CriadorBebida;
import br.com.hamburgueria.cardapio.CriadorLanche;
import br.com.hamburgueria.cardapio.CriadorLancheClassico;
import br.com.hamburgueria.cardapio.CriadorLancheSmash;
import br.com.hamburgueria.cardapio.CriadorLancheVegano;
import br.com.hamburgueria.cardapio.CriadorRefrigerante;
import br.com.hamburgueria.cardapio.CriadorSuco;
import br.com.hamburgueria.cardapio.GerenciadorCardapio;
import br.com.hamburgueria.cardapio.NivelAcesso;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.dominio.ProcessoCheckout;
import br.com.hamburgueria.dominio.CheckoutBalcao;
import br.com.hamburgueria.dominio.CheckoutDelivery;
import br.com.hamburgueria.ingredientes.CatalogoIngredientes;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.pagamento.CatalogoPagamentos;
import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pagamento.InterpretadorCupom;
import br.com.hamburgueria.pagamento.PoliticaDesconto;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pedidos.CatalogoFavoritos;
import br.com.hamburgueria.pedidos.CicloPedido;
import br.com.hamburgueria.pedidos.HistoricoMontagem;
import br.com.hamburgueria.pedidos.MontadorPedido;
import br.com.hamburgueria.pedidos.PedidoEmMontagem;
import br.com.hamburgueria.pedidos.PedidoFavorito;
import br.com.hamburgueria.pedidos.PedidoTextoLido;
import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.produtos.Lanche;

import java.util.List;

public class Hamburgueria {

    private final AtendimentoHamburgueria atendimento;
    private final TotemAutoatendimento totem;
    private final Cardapio cardapio;
    private final CardapioComCombos cardapioCombos;
    private final CatalogoPagamentos pagamentos;
    private final CatalogoReceitas receitas;
    private final CatalogoIngredientes ingredientes;
    private final CatalogoFavoritos favoritos;
    private final InterpretadorCupom cupons;
    private final CalculadoraDesconto calculadoraDesconto;
    private final CriadorLanche criadorClassico;
    private final CriadorLanche criadorSmash;
    private final CriadorLanche criadorVegano;
    private final CriadorBebida criadorRefrigerante;
    private final CriadorBebida criadorSuco;
    private final HistoricoMontagem historicoMontagem;
    private final MontadorPedido montadorPedido;

    public Hamburgueria() {
        this.atendimento = new AtendimentoHamburgueria();
        this.totem = atendimento.getTotem();
        this.cardapio = Cardapio.getInstance();
        this.cardapioCombos = CardapioComCombos.getInstance();
        this.pagamentos = new CatalogoPagamentos();
        this.receitas = new CatalogoReceitas();
        this.ingredientes = new CatalogoIngredientes();
        this.favoritos = new CatalogoFavoritos();
        this.cupons = new InterpretadorCupom();
        this.calculadoraDesconto = new CalculadoraDesconto(new DescontoPadrao());
        this.criadorClassico = new CriadorLancheClassico();
        this.criadorSmash = new CriadorLancheSmash();
        this.criadorVegano = new CriadorLancheVegano();
        this.criadorRefrigerante = new CriadorRefrigerante();
        this.criadorSuco = new CriadorSuco();
        this.historicoMontagem = new HistoricoMontagem();
        this.montadorPedido = new MontadorPedido();
    }


    public Lanche criarLancheClassico() {
        return criadorClassico.criar();
    }

    public Lanche criarLancheSmash() {
        return criadorSmash.criar();
    }

    public Lanche criarLancheVegano() {
        return criadorVegano.criar();
    }

    public Bebida pedirRefrigerante() {
        return criadorRefrigerante.criar();
    }

    public Bebida pedirSuco() {
        return criadorSuco.criar();
    }

    public String descreverCardapio() {
        return atendimento.descreverCardapio();
    }

    public PedidoTextoLido pedirPorTexto(String texto) {
        return atendimento.pedirPorTexto(texto);
    }

    public Lanche montarLanche(String texto) {
        return atendimento.montarLanchePorTexto(texto);
    }

    public FichaTecnica fichaTecnica(String texto) {
        return atendimento.obterFichaTecnica(texto);
    }

    public Pedido montarPedido(String texto) {
        return atendimento.montarPedidoCompleto(texto, new DescontoPadrao());
    }

    public Pedido realizarPedido(String texto, FormaPagamento forma) {
        return atendimento.realizarPedido(texto, new DescontoPadrao(), forma);
    }

    public ProcessoCheckout.ResultadoCheckout checkoutBalcao(String texto, FormaPagamento forma) {
        return atendimento.finalizarNoBalcao(texto, new DescontoPadrao(), forma);
    }

    public ProcessoCheckout.ResultadoCheckout checkoutDelivery(String texto, FormaPagamento forma, String endereco) {
        return atendimento.finalizarNoDelivery(texto, new DescontoPadrao(), forma, endereco);
    }

    public PoliticaDesconto cupom(String codigo) { return cupons.interpretar(codigo); }

    public double totalComCupom(String texto, String cupom) { return atendimento.calcularComCupom(texto, cupom); }

    public FormaPagamento formaDePagamento(String chave) { return pagamentos.obter(chave); }

    public List<String> etapasDaReceita(String tipo) { return receitas.etapasDe(tipo); }

    public List<String> ingredientesDisponiveis() { return ingredientes.listarDescricoes(); }

    public GerenciadorCardapio gerenciarComo(NivelAcesso nivel) { return atendimento.gerenciarCardapioComo(nivel); }

    public PedidoEmMontagem iniciarMontagem(String tipo) { return atendimento.iniciarMontagem(tipo); }

    public void salvarMontagem(PedidoEmMontagem m) { atendimento.salvarEstadoMontagem(m, historicoMontagem); }

    public void desfazerMontagem(PedidoEmMontagem m) { atendimento.desfazerMontagem(m, historicoMontagem); }

    public void salvarFavorito(String nome, PedidoFavorito favorito) { atendimento.salvarFavorito(nome, favorito); }

    public PedidoFavorito pedirFavorito(String nome) { return atendimento.pedirFavorito(nome); }

    public CicloPedido atender(String texto) { return atendimento.atenderPorTexto(texto); }

    public MontadorPedido novoMontador() { return montadorPedido; }

    public CalculadoraDesconto getCalculadoraDesconto() { return calculadoraDesconto; }

    public AtendimentoHamburgueria getAtendimento() { return atendimento; }

    public TotemAutoatendimento getTotem() { return totem; }

    public Cardapio getCardapio() { return cardapio; }

    public CardapioComCombos getCardapioCombos() { return cardapioCombos; }

    public CatalogoPagamentos getPagamentos() { return pagamentos; }

    public CatalogoReceitas getReceitas() { return receitas; }

    public CatalogoIngredientes getIngredientes() { return ingredientes; }

    public CatalogoFavoritos getFavoritos() { return favoritos; }

    public InterpretadorCupom getCupons() { return cupons; }
}
