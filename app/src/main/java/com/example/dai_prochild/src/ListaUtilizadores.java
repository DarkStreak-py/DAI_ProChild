package com.example.dai_prochild.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class ListaUtilizadores implements Serializable {

    private HashMap<String, Utilizadores> listaUtilizadores;

    //Construtor
    public ListaUtilizadores()
    {listaUtilizadores = new HashMap<>();}


    //Exceptions
    public class UtilizadorNaoExisteException extends Exception
    {
        public UtilizadorNaoExisteException(){}
        public UtilizadorNaoExisteException(String message)
        {super(message);}
    }

    public class UtilizadorDuplicadoException extends Exception
    {
        public UtilizadorDuplicadoException(){}
        public UtilizadorDuplicadoException(String message)
        {super(message);}
    }



    //insere um utilizador
    public void inserirUtilizador(Utilizadores user) throws UtilizadorDuplicadoException
    {
        if(user == null)
        {throw new NullPointerException("'Utilizador' não pode ser nulo");}

        if(!listaUtilizadores.containsKey(user.getUsername()))
        {listaUtilizadores.put(user.getUsername(), user);}
        else
        {throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já se encontra definido", user.getUsername()));}
    }

    //remover todos os utilizadores
    public void removerTodosUtilizadores(){
        listaUtilizadores.clear();
    }

    //retorna o utilizador escolhido
    public Utilizadores getUtilizador(String username){
        return listaUtilizadores.get(username);
    }

    //confirma se o utilizador existe
    public boolean existeUtilizador(String username){
        return listaUtilizadores.containsKey(username);
    }

    //remove um utilizador
    public void removeUtilizador(String username){
        listaUtilizadores.remove(username);
    }

    //N«numero de utilizadores
    public int size(){
        return listaUtilizadores.size();
    }

    //passa tudo de hasmap para arraylist
    public ArrayList<Utilizadores> TudoDosUtilizadores(){
        return new ArrayList<>(listaUtilizadores.values());
    }

    //procura um utilizador
    public Utilizadores procuraUtilizador(String username) throws UtilizadorNaoExisteException{
        if (listaUtilizadores.containsKey(username))
        {return listaUtilizadores.get(username);}
        else
        {throw new UtilizadorNaoExisteException("O utilizador '%s' já existe na lista");}
    }

    //toString
    public String toString(){
        String s = "vazio";
        for(int i=0; i<listaUtilizadores.size(); i++){
            s += listaUtilizadores.get(i).toString();
        }
        return s;
    }
}
