package com.example.dai_prochild.src;
import java.io.Serializable;

public class Utilizadores implements Serializable {
    //Variaveis

    protected Integer userid;
    protected String  username;
    protected String  nome;
    protected String  password;
    protected String  type;
    protected String nomeInst;


    public Utilizadores() { }
    // Constructor
    public Utilizadores(Integer userid, String username, String nome, String password, String type, String nomeInst) {
        this.userid = userid;
        this.username = username;
        this.nome = nome;
        this.password = password;
        this.type = type;
        this.nomeInst = nomeInst;
    }

    //Seletores
    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() { return password; }

    public String getType() {
        return type;
    }

    public String getNomeInst() {
        return nomeInst;
    }

    //Modificadores
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public void setType(String type) {
        this.type=type;
    }

    public void setNomeInst(String nomeInst) {this.nomeInst=nomeInst;}


}