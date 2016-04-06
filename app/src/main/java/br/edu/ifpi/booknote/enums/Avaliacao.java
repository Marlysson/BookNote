package br.edu.ifpi.booknote.enums;

public enum Avaliacao {
    NÃO_GOSTEI("Não Gostei"), BOM("Bom"), ADOREI("Adorei");

    private String avaliacao;

    private Avaliacao(String avaliacao){
        this.avaliacao = avaliacao;
    }

    public String toString(){
        return this.avaliacao;
    }

}

