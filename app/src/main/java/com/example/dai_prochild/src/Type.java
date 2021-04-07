package com.example.dai_prochild.src;
import java.io.Serializable;


public class Type implements Serializable {
    //VariÃ¡veis

    protected Integer id_type;
    protected String  type;


    public Type() { }
    // Constructor
    public Type(Integer id_type, String type) {
        this.id_type = id_type;
        this.type = type;

    }

    //Seletores
    public Integer id_type() {
        return id_type;
    }
    public String type() {
        return type;
    }



    //Modificadores
    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public void setType(String type) {
        this.type = type;
    }




}