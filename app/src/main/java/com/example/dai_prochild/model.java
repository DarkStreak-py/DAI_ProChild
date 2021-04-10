package com.example.dai_prochild;

public class model
{
  String name,descricao,purl;
    model()
    {

    }
    public model(String name, String descricao,  String purl) {
        this.name = name;
        this.descricao = descricao;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
