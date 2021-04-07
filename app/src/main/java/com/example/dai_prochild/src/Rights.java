package com.example.dai_prochild.src;


import java.io.Serializable;
import java.util.Date;

public class Rights implements Serializable {
    //VariÃ¡veis

    protected Integer id_rights;
    protected String  nome;
    protected String description;

    public Rights() { }
    // Constructor
    public Rights(Integer id_rights, String nome, String description) {
        this.id_rights = id_rights;
        this.nome = nome;
        this.description = description;

    }

    //Seletores
    public Integer getId_rights() {
        return id_rights;
    }

    public String getNome() {
        return nome;
    }
    public String getDescription() {
        return description;
    }


    //Modificadores
    public void setId_rights(Integer id_rights) {
        this.id_rights = id_rights;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}