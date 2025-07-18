package com.Bank.StringProva.Entidade;

public class ClienteBanco {
    private Integer id;
    private String nome;
    private String sobrenome;

    public ClienteBanco(Integer id, String nome, String sobrenome){
        this.id=id;
        this.nome=nome;
        this.sobrenome=sobrenome;
    }

    public Integer getId() {
        return id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
