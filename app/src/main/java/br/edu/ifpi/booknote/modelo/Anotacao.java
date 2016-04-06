package br.edu.ifpi.booknote.modelo;

public class Anotacao{

    private int id;
    private String titulo;
    private String conteudo;
    private int paginaInicial;
    private int paginaFinal;

    public Anotacao(String titulo){
        this.titulo = titulo;
    }

    public int getId(){
        return this.id;
    }

    public void setPaginaInicial(int pagInicio){
        this.paginaInicial = pagInicio;
    }

    public int getPaginaInicial(){
        return this.paginaInicial;
    }

    public void setPaginaFinal(int pagFinal){
        this.paginaFinal = pagFinal;
    }

    public int getPaginaFinal(){
        return this.paginaFinal;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String toString(){
        String retorno = this.titulo+"\n";

        retorno +="\nConteúdo: "+this.conteudo;

        retorno += "\nPáginas : "+this.paginaInicial+" até " + this.paginaFinal;

        return retorno;
    }

}
