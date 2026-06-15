package br.com.hamburgueria.proxy;

public class GerenciadorCardapioProxy implements GerenciadorCardapio {

    private GerenciadorCardapioReal gerenciadorReal;
    private NivelAcesso nivelAcesso;

    public GerenciadorCardapioProxy(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
        this.gerenciadorReal = new GerenciadorCardapioReal();
    }

    private boolean temPermissao() {
        return nivelAcesso == NivelAcesso.GERENTE;
    }

    @Override
    public void adicionarItem(String nome, double preco) {
        if (!temPermissao()) {
            System.out.println("Acesso negado. Apenas gerentes podem adicionar itens.");
            return;
        }
        gerenciadorReal.adicionarItem(nome, preco);
    }

    @Override
    public void removerItem(String nome) {
        if (!temPermissao()) {
            System.out.println("Acesso negado. Apenas gerentes podem remover itens.");
            return;
        }
        gerenciadorReal.removerItem(nome);
    }

    @Override
    public void alterarPreco(String nome, double novoPreco) {
        if (!temPermissao()) {
            System.out.println("Acesso negado. Apenas gerentes podem alterar precos.");
            return;
        }
        gerenciadorReal.alterarPreco(nome, novoPreco);
    }

    @Override
    public void exibirItensGerenciados() {
        gerenciadorReal.exibirItensGerenciados();
    }
}
