package br.edu.ifpi.booknote.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.booknote.enums.Avaliacao;
import br.edu.ifpi.booknote.enums.Situacao;

public class Leitura{
	/*
		Guardar as anotações relevantes de cada leitura.

		Classe para guardar os estados da leitura do usuários, usando uma composição de
		Livro para fazer uma conexão do elemento concreto com os atos que envolvem esse
		elemento.
		- Avaliacao da leitura(livro) - Não gostei , Bom , Adorei

	*/

    public int id;
    private Leitor leitor;
    private Livro livro;
    private Avaliacao avaliacaoLeitura;
    private Data comecoLeitura;
    private Data finalLeitura;
    private List<Capitulo> capitulosLidos;

    Leitura(Livro livro, Leitor leitor){
        this.livro = livro;
        this.livro.setSituacao(Situacao.LENDO);
        this.leitor = leitor;
        this.capitulosLidos = new ArrayList<Capitulo>();
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public void finalizarLeitura(){
        this.livro.setSituacao(Situacao.LIDO);

    }

    public Data getInicioLeitura(){
        return this.comecoLeitura;
    }

    public void setInicioLeitura(Data data){
        this.comecoLeitura = data;
    }

    public Data getFinalLeitura(){
        return this.finalLeitura;
    }

    public void setFinalLeitura(Data data){
        this.finalLeitura = data;
    }

    public void addCapitulo(Capitulo capitulo){
        this.capitulosLidos.add(capitulo);
    }

    public float getProgresso(){
        float parte;

        try{
            parte = this.livro.getQuantCapitulos() / this.capitulosLidos.size();
        }catch (ArithmeticException e){
            parte = 0;
        }


        return parte / 100;
    }

    public Avaliacao getAvaliacaoLeitura(){
        return this.avaliacaoLeitura;
    }

    public void setAvaliacao(Avaliacao avaliacao){
        this.avaliacaoLeitura = avaliacao;
    }


}