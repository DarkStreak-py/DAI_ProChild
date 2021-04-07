package com.example.dai_prochild.src;
import java.io.Serializable;

public class Utilizadores implements Serializable {
    //VariÃ¡veis

    protected Integer userid;
    protected String  username;
    protected String  nome;
    protected String  password;





    public Utilizadores() { }
    // Constructor
    public Utilizadores(Integer userid, String username, String nome, String password) {
        this.userid = userid;
        this.username = username;
        this.nome = nome;
        this.password = password;
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

    public String getPassword() {
        return password;

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


}