package br.com.hamburgueria;

import br.com.hamburgueria.abstractfactory.*;
import br.com.hamburgueria.bridge.*;
import br.com.hamburgueria.builder.PedidoBuilder;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.chainofresponsibility.*;
import br.com.hamburgueria.composite.*;
import br.com.hamburgueria.component.Lanche;
import br.com.hamburgueria.concretecomponent.*;
import br.com.hamburgueria.concretedecorator.*;
import br.com.hamburgueria.facade.HamburgueriafFacade;
import br.com.hamburgueria.factory.*;
import br.com.hamburgueria.flyweight.*;
import br.com.hamburgueria.iterator.*;
import br.com.hamburgueria.mediator.*;
import br.com.hamburgueria.memento.*;
import br.com.hamburgueria.observer.*;
import br.com.hamburgueria.prototype.*;
import br.com.hamburgueria.state.*;
import br.com.hamburgueria.strategy.*;
import br.com.hamburgueria.templatemethod.*;
import br.com.hamburgueria.visitor.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes — Hamburgueria (Todos os Padrões)")
class HamburgueriaTest {

    @Test
    @DisplayName("Singleton: duas chamadas getInstance() retornam a mesma instância")
    void testSingletonMesmaInstancia() {
        Cardapio a = Cardapio.getInstance();
        Cardapio b = Cardapio.getInstance();
        assertSame(a, b);
    }

    @Test
    @DisplayName("Singleton: tipo inválido lança IllegalArgumentException")
    void testSingletonTipoInvalido() {
        assertThrows(IllegalArgumentException.class,
            () -> Cardapio.getInstance().getFabrica("Inexistente"));
    }

    @Test
    @DisplayName("Factory: ClassicoFactory cria HamburguerClassico com preço R$22,00")
    void testFactoryClassico() {
        Lanche l = new ClassicoFactory().criar();
        assertInstanceOf(HamburguerClassico.class, l);
        assertEquals(22.00, l.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Factory: SmashFactory cria HamburguerSmash com preço R$28,00")
    void testFactorySmash() {
        Lanche l = new SmashFactory().criar();
        assertInstanceOf(HamburguerSmash.class, l);
        assertEquals(28.00, l.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Abstract Factory: IngredientesClassicoFactory cria ingredientes corretos")
    void testAbstractFactoryClassico() {
        IngredientesFactory fab = new IngredientesClassicoFactory();
        assertTrue(fab.criarPao().getDescricao().contains("Brioche"));
        assertTrue(fab.criarCarne().getDescricao().contains("Bovino"));
    }

    @Test
    @DisplayName("Abstract Factory: famílias diferentes criam ingredientes distintos")
    void testAbstractFactoryFamiliasDiferentes() {
        IngredientesFactory fabClassico = new IngredientesClassicoFactory();
        IngredientesFactory fabVegano = new IngredientesVeganoFactory();
        assertNotEquals(fabClassico.criarPao().getDescricao(), fabVegano.criarPao().getDescricao());
    }

    @Test
    @DisplayName("Decorator: Queijo adiciona +R$3,00 e altera descrição")
    void testDecoratorQueijo() {
        Lanche l = new Queijo(new HamburguerClassico());
        assertEquals(25.00, l.getPreco(), 0.001);
        assertTrue(l.getDescricao().contains("Queijo Cheddar"));
    }

    @Test
    @DisplayName("Decorator: objeto original não é modificado após decoração")
    void testOriginalImutavel() {
        Lanche base = new HamburguerClassico();
        double precoOriginal = base.getPreco();
        new Queijo(base).getPreco();
        assertEquals(precoOriginal, base.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Decorator: Smash completo = R$39,00")
    void testSmashCompleto() {
        Lanche l = new HamburguerSmash();
        l = new Queijo(l);
        l = new Bacon(l);
        l = new Alface(l);
        l = new Tomate(l);
        l = new MolhoEspecial(l);
        assertEquals(39.00, l.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Builder: build() cria pedido com tipo e adicionais corretos")
    void testBuilderCriaPedido() {
        br.com.hamburgueria.builder.Pedido pedido = new PedidoBuilder()
                .setTipoLanche("Classico")
                .adicionarQueijo()
                .adicionarBacon()
                .build();
        assertEquals("Classico", pedido.getTipoLanche());
        assertTrue(pedido.getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    @DisplayName("Builder: build() sem tipo lança IllegalStateException")
    void testBuilderSemTipoLancaExcecao() {
        assertThrows(IllegalStateException.class, () -> new PedidoBuilder().build());
    }

    @Test
    @DisplayName("Memento: desfazer remove o último ingrediente adicionado")
    void testMementoDesfaz() {
        PedidoEmMontagem pedido = new PedidoEmMontagem();
        HistoricoPedido historico = new HistoricoPedido();
        pedido.setTipoLanche("Smash");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Queijo");
        historico.salvar(pedido.salvarEstado());
        pedido.adicionarIngrediente("Bacon");
        historico.salvar(pedido.salvarEstado());
        pedido.restaurarEstado(historico.desfazer());
        assertFalse(pedido.getAdicionais().contains("Bacon"));
        assertTrue(pedido.getAdicionais().contains("Queijo"));
    }

    @Test
    @DisplayName("Memento: desfazer sem histórico lança IllegalStateException")
    void testMementoSemHistorico() {
        assertThrows(IllegalStateException.class, new HistoricoPedido()::desfazer);
    }

    @Test
    @DisplayName("State: fluxo completo Aguardando -> EmPreparo -> Pronto -> Entregue")
    void testStateFluxoCompleto() {
        ContextoPedido ctx = new ContextoPedido();
        ctx.confirmar();
        ctx.preparar();
        ctx.entregar();
        assertEquals("Entregue", ctx.getStatus());
    }

    @Test
    @DisplayName("State: cancelar em Aguardando muda para Cancelado")
    void testStateCancelar() {
        ContextoPedido ctx = new ContextoPedido();
        ctx.cancelar();
        assertEquals("Cancelado", ctx.getStatus());
    }

    @Test
    @DisplayName("Observer: observer recebe notificação de novo pedido")
    void testObserverNotificado() {
        FilaPedidos fila = new FilaPedidos();
        List<String> recebidos = new ArrayList<>();
        fila.adicionarObserver((evento, desc) -> recebidos.add(desc));
        fila.novoPedido("Smash + Queijo");
        assertEquals(1, recebidos.size());
    }

    @Test
    @DisplayName("Observer: múltiplos observers recebem o mesmo evento")
    void testObserverMultiplos() {
        FilaPedidos fila = new FilaPedidos();
        int[] contador = {0};
        fila.adicionarObserver((e, d) -> contador[0]++);
        fila.adicionarObserver((e, d) -> contador[0]++);
        fila.novoPedido("Vegano");
        assertEquals(2, contador[0]);
    }

    @Test
    @DisplayName("Strategy: desconto estudante aplica 15%")
    void testStrategyEstudante() {
        CalculadoraPreco calc = new CalculadoraPreco(new DescontoEstudante());
        assertEquals(29.75, calc.calcularPrecoFinal(35.00), 0.001);
    }

    @Test
    @DisplayName("Strategy: trocar strategy em tempo de execução funciona")
    void testStrategyTroca() {
        CalculadoraPreco calc = new CalculadoraPreco(new SemDesconto());
        assertEquals(35.00, calc.calcularPrecoFinal(35.00), 0.001);
        calc.setStrategy(new DescontoEstudante());
        assertEquals(29.75, calc.calcularPrecoFinal(35.00), 0.001);
    }

    @Test
    @DisplayName("Template Method: PreparoClassico executa sem erros")
    void testTemplateMethodClassico() {
        assertDoesNotThrow(new PreparoClassico()::preparar);
    }

    @Test
    @DisplayName("Template Method: subclasses são instâncias de PreparoLanche")
    void testTemplateMethodHeranca() {
        assertInstanceOf(PreparoLanche.class, new PreparoClassico());
        assertInstanceOf(PreparoLanche.class, new PreparoVegano());
    }

    @Test
    @DisplayName("Chain of Responsibility: pedido válido é processado")
    void testChainPedidoValido() {
        ManipuladorPedido cadeia = new ValidadorEstoque();
        cadeia.setProximo(new ValidadorPagamento()).setProximo(new ProcessadorPedido());
        SolicitacaoPedido sol = new SolicitacaoPedido("Smash", 35.00);
        cadeia.processar(sol);
        assertTrue(sol.isProcessado());
    }

    @Test
    @DisplayName("Chain of Responsibility: pedido com valor zero não é processado")
    void testChainPedidoInvalido() {
        ManipuladorPedido cadeia = new ValidadorEstoque();
        cadeia.setProximo(new ValidadorPagamento()).setProximo(new ProcessadorPedido());
        SolicitacaoPedido sol = new SolicitacaoPedido("Classico", 0.00);
        cadeia.processar(sol);
        assertFalse(sol.isProcessado());
    }

    @Test
    @DisplayName("Mediator: fluxo completo não lança exceção")
    void testMediatorFluxo() {
        Cozinha cozinha = new Cozinha();
        Caixa caixa = new Caixa();
        Entregador entregador = new Entregador();
        assertDoesNotThrow(() -> {
            new RestauranteConcreteMediator(cozinha, caixa, entregador);
            caixa.registrarPedido("Smash + Queijo");
        });
    }

    @Test
    @DisplayName("Composite: Combo soma preços dos itens corretamente")
    void testCompositeSomaPrecos() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("Hamburguer", 22.00));
        combo.adicionar(new ItemSimples("Refrigerante", 6.00));
        assertEquals(28.00, combo.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Composite: CardapioComCombos registra 3 combos")
    void testCompositeCardapioComCombos() {
        assertEquals(3, CardapioComCombos.getInstance().getCombos().size());
    }

    @Test
    @DisplayName("Visitor: VisitorResumoCardapio contabiliza total corretamente")
    void testVisitorResumo() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("Item A", 10.00));
        combo.adicionar(new ItemSimples("Item B", 15.00));
        VisitorResumoCardapio visitor = new VisitorResumoCardapio();
        combo.aceitar(visitor);
        assertEquals(25.00, visitor.getTotalGeral(), 0.001);
    }

    @Test
    @DisplayName("Visitor: VisitorItensPorPreco filtra itens acima do preço máximo")
    void testVisitorFiltroPorPreco() {
        Combo combo = new Combo("Teste");
        combo.adicionar(new ItemSimples("Barato", 5.00));
        combo.adicionar(new ItemSimples("Caro", 50.00));
        VisitorItensPorPreco visitor = new VisitorItensPorPreco(10.00);
        combo.aceitar(visitor);
        assertEquals(1, visitor.getItensFiltrados().size());
    }

    @Test
    @DisplayName("Bridge: PedidoBalcao com PIX finaliza sem erro")
    void testBridgeBalcao() {
        br.com.hamburgueria.bridge.Pedido pedido = new PedidoBalcao("Classico", 22.00, new PagamentoPix());
        assertDoesNotThrow(pedido::finalizar);
        assertEquals(22.00, pedido.getTotal(), 0.001);
    }

    @Test
    @DisplayName("Bridge: trocar forma de pagamento em tempo de execução")
    void testBridgeTrocaPagamento() {
        br.com.hamburgueria.bridge.Pedido pedido = new PedidoBalcao("Vegano", 26.00, new PagamentoDinheiro());
        pedido.setFormaPagamento(new PagamentoPix());
        assertDoesNotThrow(pedido::finalizar);
    }

    @Test
    @DisplayName("Facade: pedirLancheCompleto retorna preço com todos os adicionais")
    void testFacadeLancheCompleto() {
        HamburgueriafFacade facade = new HamburgueriafFacade();
        Lanche l = facade.pedirLancheCompleto("Smash");
        assertEquals(39.00, l.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Facade: pedirLancheSimples retorna lanche base sem adicionais")
    void testFacadeLancheSimples() {
        HamburgueriafFacade facade = new HamburgueriafFacade();
        Lanche l = facade.pedirLancheSimples("Clássico");
        assertEquals(22.00, l.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Flyweight: mesma chave retorna a mesma instância do cache")
    void testFlyweightMesmaInstancia() {
        IngredientesFactory fab = new IngredientesClassicoFactory();
        IngredienteFlyweight pao1 = FabricaIngredientesFlyweight.getPao(fab.criarPao());
        IngredienteFlyweight pao2 = FabricaIngredientesFlyweight.getPao(fab.criarPao());
        assertSame(pao1, pao2);
    }

    @Test
    @DisplayName("Flyweight: chaves diferentes retornam instâncias diferentes")
    void testFlyweightInstanciasDiferentes() {
        IngredienteFlyweight paoClassico = FabricaIngredientesFlyweight.getPao(new IngredientesClassicoFactory().criarPao());
        IngredienteFlyweight paoSmash    = FabricaIngredientesFlyweight.getPao(new IngredientesSmashFactory().criarPao());
        assertNotSame(paoClassico, paoSmash);
    }

    @Test
    @DisplayName("Iterator: percorre todos os itens sem pular nenhum")
    void testIteratorCompleto() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        IteratorCardapioCompleto iterator = new IteratorCardapioCompleto(combos);
        int count = 0;
        while (iterator.temProximo()) {
            assertNotNull(iterator.proximo());
            count++;
        }
        assertEquals(iterator.getTotalItens(), count);
    }

    @Test
    @DisplayName("Iterator: reiniciar volta ao início da coleção")
    void testIteratorReiniciar() {
        List<Combo> combos = new ArrayList<>(CardapioComCombos.getInstance().getCombos().values());
        IteratorCardapioCompleto iterator = new IteratorCardapioCompleto(combos);
        ItemCardapio primeiro = iterator.proximo();
        iterator.reiniciar();
        assertEquals(primeiro.getNome(), iterator.proximo().getNome());
    }

    @Test
    @DisplayName("Prototype: clone é instância diferente com os mesmos dados")
    void testPrototypeClone() {
        RegistroDeFavoritos registro = new RegistroDeFavoritos();
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        registro.salvar("fav", original);
        PedidoFavorito clone = registro.clonar("fav");
        assertNotSame(original, clone);
        assertEquals(original.getTipoLanche(), clone.getTipoLanche());
    }

    @Test
    @DisplayName("Prototype: alterar o clone não afeta o original")
    void testPrototypeOriginalImutavel() {
        RegistroDeFavoritos registro = new RegistroDeFavoritos();
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        registro.salvar("fav", original);
        registro.clonar("fav").adicionarAdicional("Bacon");
        assertFalse(original.getAdicionais().contains("Bacon"));
    }
}
