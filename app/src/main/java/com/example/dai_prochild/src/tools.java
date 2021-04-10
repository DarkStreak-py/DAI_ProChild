package com.example.dai_prochild.src;

public class tools  {

        String name,purl;
    public tools() {

    }
    public tools(String name, String purl) {
        this.name = name;
        this.purl = purl;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}