package com.example.dai_prochild.src;


import java.io.Serializable;
import java.sql.Time;


public class Forum_Request implements Serializable {

    //VariÃ¡veis
    protected Integer id_forum_request;
    protected Time create_at;


    public Forum_Request() { }

    // Constructor
    public Forum_Request(Integer id_forum_request, Time create_at) {
        this.id_forum_request = id_forum_request;
        this.create_at = create_at;


    }
    //Seletores

    public Integer getId_forum_request() {
        return id_forum_request;
    }

    public Time getCreate_at() {
        return create_at;
    }



    //Modificadores
    public void setId_report(Integer id_report) {
        this.id_forum_request = id_forum_request;
    }
    public void setCreate_at(Time create_at) {
        this.create_at = create_at;
    }




}