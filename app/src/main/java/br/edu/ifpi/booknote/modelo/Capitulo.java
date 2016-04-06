package br.edu.ifpi.booknote.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 03/04/2016.
 */

public class Capitulo{

    private int id;
    private String titulo;
    private List<Anotacao> anotacoes;

    public Capitulo(String titulo){
        this.titulo = titulo;
        this.anotacoes = new ArrayList<Anotacao>();
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void addAnotacao(Anotacao nota){
        this.anotacoes.add(nota);
    }

    public List<Anotacao> getAnotacoes(){
        return this.anotacoes;
    }

    public String toString(){
        String retorno = "";

        retorno += "Capítulo: "+this.titulo+"\n";

        for(Anotacao nota: this.anotacoes){
            retorno += "Nota: "+nota.getTitulo()+"\n";
            retorno += nota.getConteudo();
            retorno += "Páginas: "+nota.getPaginaInicial()+" até "+nota.getPaginaInicial();
        }

        return retorno;
    }
}


