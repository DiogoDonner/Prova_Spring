package com.Bank.StringProva.Entidade;

import java.util.List;

public class ContaBanco {
    private Integer id;
    private ClienteBanco cliente;
    private double saldo;
    private List<MovimentacaoBanco> movimentacoes;

    public ContaBanco(Integer id, ClienteBanco cliente, double saldo, List<MovimentacaoBanco> movimentacoes){
        this.id=id;
        this.cliente=cliente;
        this.saldo=saldo;
        this.movimentacoes=movimentacoes;
    }

    public double getSaldo() {
        return saldo;
    }

    public ClienteBanco getCliente() {
        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public List<MovimentacaoBanco> getMovimentacoes() {
        return movimentacoes;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
