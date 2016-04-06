package br.edu.ifpi.booknote.modelo;

public class Leitor {

    private int id;
    private String nome;
    private int idade;
//    private Sexo sexo;
    private String sexo;

    public Leitor(String nome, int idade, String sexo){
        this.nome = nome;
        this.idade  = idade;
        this.sexo = sexo;
    }

    public Leitor(String nome, String idade){
        this.nome = nome;
        this.idade = Integer.valueOf(idade);
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){ this.id = id;}

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getSexo(){
        return this.sexo;
    }

    public String toString(){
        String retorno = "";

        retorno += "Nome: "+this.nome+"\n";
        retorno += "Idade: "+this.idade+"\n";
        retorno += "Sexo: "+this.sexo+"\n";

        return retorno;
    }
}

