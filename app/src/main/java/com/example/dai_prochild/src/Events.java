package com.example.dai_prochild.src;


import java.io.Serializable;
import java.util.Date;

public class Events implements Serializable {
    //VariÃ¡veis

    protected Integer id_event;
    protected String  nome;
    protected Date data;

    public Events() { }
    // Constructor
    public Events(Integer id_event, String nome, Date data) {
        this.id_event = id_event;
        this.nome = nome;
        this.data = data;

    }

    //Seletores
    public Integer getId_event() {
        return id_event;
    }

    public String getNome() {
        return nome;
    }
    public Date getData() {
        return data;
    }


    //Modificadores
    public void setId_event(Integer id_event) {
        this.id_event = id_event;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Date data) {
        this.data = data;
    }

}