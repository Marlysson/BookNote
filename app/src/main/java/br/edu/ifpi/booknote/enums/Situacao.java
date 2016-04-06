package br.edu.ifpi.booknote.enums;

public enum Situacao {
    LIDO("Lido"), LENDO("Lendo"), DESEJADO("Desejado");

    private String estadoLeitura;

    private Situacao(String estadoLeitura){
        this.estadoLeitura = estadoLeitura;
    }

    public String toString(){
        return this.estadoLeitura;
    }


}
