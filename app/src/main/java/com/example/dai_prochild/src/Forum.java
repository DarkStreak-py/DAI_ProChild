package com.example.dai_prochild.src;


import java.io.Serializable;
import java.sql.Time;


public class Forum implements Serializable {

    //VariÃ¡veis
    protected Integer id_forum;
    protected Time create_at;
    protected Time updated_at;
    protected String body;



    public Forum() { }

    // Constructor
    public Forum(Integer id_forum, Time create_at,Time updated_at, String body ) {
        this.id_forum = id_forum;
        this.create_at = create_at;
        this.updated_at = updated_at;
        this.body = body;


    }
    //Seletores

    public Integer getId_forum() {
        return id_forum;
    }

    public Time getCreate_at() {
        return create_at;
    }
    public Time getUpdated_at() {
        return updated_at;
    }
    public String getBody() {
        return body;
    }



    //Modificadores
    public void setId_forum(Integer id_forum) {
        this.id_forum = id_forum;
    }
    public void setCreate_at(Time create_at) {
        this.create_at = create_at;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setUpdated_at(Time updated_at) {
        this.updated_at = updated_at;
    }




}