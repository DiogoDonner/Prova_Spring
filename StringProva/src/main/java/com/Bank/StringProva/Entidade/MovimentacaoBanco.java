package com.Bank.StringProva.Entidade;

public class MovimentacaoBanco {
    private Integer id;
    private String tipo;
    private double valor;

    public MovimentacaoBanco(Integer id, String tipo, double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }


    public Integer getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
