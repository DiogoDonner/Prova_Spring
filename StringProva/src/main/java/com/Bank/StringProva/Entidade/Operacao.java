package com.Bank.StringProva.Entidade;

public class Operacao {
    private double valor;

    public Operacao() {
        // Necessário para Spring criar o objeto
    }

    public Operacao(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
