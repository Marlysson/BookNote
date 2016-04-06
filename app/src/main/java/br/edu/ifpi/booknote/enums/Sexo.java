package br.edu.ifpi.booknote.enums;

/**
 * Created by Cliente on 05/04/2016.
 */
public enum Sexo {
    MASCULINO("Masculino"),FEMININO("Feminino");

    private String sexo;

    private Sexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.sexo;
    }
}
