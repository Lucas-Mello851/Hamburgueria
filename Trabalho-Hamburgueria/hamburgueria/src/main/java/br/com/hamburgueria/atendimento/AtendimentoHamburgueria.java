package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pagamento.PedidoBalcao;
import br.com.hamburgueria.pagamento.PedidoDelivery;
import br.com.hamburgueria.pedidos.CatalogoFavoritos;
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

    public AtendimentoHamburgueria() {
        cardapio = Cardapio.getInstance();
        interpreter = new LeitorPedidoTexto();
        registroDeFavoritos = new CatalogoFavoritos();
    }

    // ── Decorator + Factory Method ────────────────────────────────────

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

    // ── Bridge: finalizar pedido balcão ou delivery ───────────────────

    public boolean finalizarPedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        PedidoBalcao pedido = new PedidoBalcao(descricao, total, formaPagamento);
        return pedido.finalizar();
    }

    public boolean finalizarPedidoDelivery(String descricao, double total, String endereco, FormaPagamento formaPagamento) {
        PedidoDelivery pedido = new PedidoDelivery(descricao, total, endereco, formaPagamento);
        return pedido.finalizar();
    }

    // ── Interpreter: pedir pelo texto falado no balcão ────────────────

    public PedidoTextoLido pedirPorTexto(String texto) {
        return interpreter.interpretar(texto);
    }

    // ── Memento: montar pedido com suporte a desfazer ─────────────────

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

    // ── Prototype: salvar e reutilizar pedidos favoritos ──────────────

    public void salvarFavorito(String nome, PedidoFavorito favorito) {
        registroDeFavoritos.salvar(nome, favorito);
    }

    public PedidoFavorito pedirFavorito(String nome) {
        return registroDeFavoritos.clonar(nome);
    }

    public boolean contemFavorito(String nome) {
        return registroDeFavoritos.contemFavorito(nome);
    }

    // ── Template Method: consultar etapas de preparo do lanche ────────

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
}
