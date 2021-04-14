package com.example.dai_prochild.src;


import java.io.Serializable;
import java.util.Date;

public class Events implements Serializable {
    //VariÃ¡veis


    protected String  nome;
    protected String data;
    protected String instituicao;

    public Events() { }
    // Constructor
    public Events( String nome, String data, String instituicao) {

        this.nome = nome;
        this.data = data;
        this.instituicao = instituicao;

    }

    //Seletores


    public String getNome() {
        return nome;
    }
    public String getData() {
        return data;
    }
    public String getInstituicao() {
        return instituicao;
    }


    //Modificadores

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

}