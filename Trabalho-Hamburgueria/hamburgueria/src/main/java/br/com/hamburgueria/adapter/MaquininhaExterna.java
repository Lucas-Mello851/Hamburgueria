package br.com.hamburgueria.adapter;

public class MaquininhaExterna {

    private String operadora;

    public MaquininhaExterna(String operadora) {
        this.operadora = operadora;
    }

    public String cobrar(double valorEmCentavos) {
        int centavos = (int) valorEmCentavos;
        System.out.println("[" + operadora + "] Cobrando " + centavos + " centavos...");
        return "APROVADO";
    }

    public String getOperadora() {
        return operadora;
    }
}
