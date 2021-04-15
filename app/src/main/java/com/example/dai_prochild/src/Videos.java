package com.example.dai_prochild.src;


    public class Videos  {

        String name,purl;
        public Videos() {

        }
        public Videos(String name, String purl) {
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

