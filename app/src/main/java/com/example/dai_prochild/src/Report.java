package com.example.dai_prochild.src;


import java.io.Serializable;


public class Report implements Serializable {

    //VariÃ¡veis
    protected Integer id_report;
    protected String  nome;
    protected String  description;

    public Report() { }

    // Constructor
    public Report(Integer id_report, String nome, String description) {
        this.id_report = id_report;
        this.nome = nome;
        this.description = description;

    }
    //Seletores

    public Integer getId_report() {
        return id_report;
    }

    public String getNome() {
        return nome;
    }

    public String getDescription() {
        return description;
    }


    //Modificadores
    public void setId_report(Integer id_report) {
        this.id_report = id_report;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescription(String description) {
        this.description = description;
    }



}