package br.edu.ifpi.booknote.modelo;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.booknote.enums.Situacao;

public class Livro{

	/*
		Classe responsável por guardar informações de todos os livros que foram
		cadastrados no sistema, seja ele que o usuário possui ou não.
		- Lido, Lendo , Desejado;

	*/
	
	private int id;
	private String titulo;
	private String autor;
	private String genero;
	private int quantCapitulos;
	private Data anoPublicacao;
	private List<String> tags;
	private Situacao situacao;
	
	public Livro(String titulo,String autor, Data publicacao){
		this.titulo = titulo;
		this.autor  = autor;
		this.anoPublicacao = publicacao;
		this.tags = new ArrayList<String>();
	}

	public Livro(String titulo,String autor, int capitulos){
		this.titulo = titulo;
		this.autor  = autor;
		this.quantCapitulos = capitulos;
		this.tags = new ArrayList<String>();
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getQuantCapitulos() {
		return this.quantCapitulos;
	}

	public void setQuantCapitulos(int capitulos) {
		this.quantCapitulos = capitulos;
	}

	public Data getAnoPublicacao() {
		return this.anoPublicacao;
	}

	public void setAnoPublicacao(Data anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public List<String> getTags() {
		return tags;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

    public void setSituacao(Situacao situacao){
        this.situacao = situacao;
    }

    public Situacao getSituacao(){
        return this.situacao;
    }

    public String toString(){
		String retorno = "";
		retorno += "Título: "+this.titulo+"\n";
		retorno += "Autor: "+this.autor+"\n";
		retorno += "Gênero "+this.genero+"\n";
		retorno += "Quantidade Capitulos: "+this.quantCapitulos+"\n";
		retorno += "Publicacao: "+this.getAnoPublicacao()+"\n";
		retorno += "Tags: "+ TextUtils.join(", ", this.tags)+"\n";
		
		return retorno;
	}
	
	
}
