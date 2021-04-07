package com.example.dai_prochild.src;


import java.io.Serializable;


public class Tools implements Serializable {
    //VariÃ¡veis
    protected Integer id_tools;
    protected String  nome;

    public Tools() { }
    // Constructor
    public Tools(Integer id_tools, String nome) {
        this.id_tools = id_tools;
        this.nome = nome;

    }
    //Seletores

    public Integer getId_tools() {
        return id_tools;
    }

    public String getNome() {
        return nome;
    }



    //Modificadores
    public void setId_tools(Integer id_tools) {
        this.id_tools = id_tools;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }



}