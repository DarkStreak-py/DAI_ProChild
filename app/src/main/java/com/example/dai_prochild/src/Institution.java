package com.example.dai_prochild.src;

import java.io.Serializable;

public class Institution implements Serializable {
    //VariÃ¡veis

    protected Integer id_institution;
    protected String  nome;

    public Institution() { }
    // Constructor
    public Institution(Integer id_institution, String nome) {
        this.id_institution = id_institution;
        this.nome = nome;

    }

    //Seletores
    public Integer getId_institution() {
        return id_institution;
    }

    public String getNome() {
        return nome;
    }


    //Modificadores
    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }




}