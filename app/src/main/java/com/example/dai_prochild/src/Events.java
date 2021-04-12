package com.example.dai_prochild.src;


import java.io.Serializable;
import java.util.Date;

public class Events implements Serializable {
    //VariÃ¡veis


    protected String  nome;
    protected String data;

    public Events() { }
    // Constructor
    public Events( String nome, String data) {

        this.nome = nome;
        this.data = data;

    }

    //Seletores


    public String getNome() {
        return nome;
    }
    public String getData() {
        return data;
    }


    //Modificadores

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

}