package br.edu.ifpi.booknote.modelo;

public class Data {

    private String dia;
    private String mes;
    private String ano;

    public Data(int dia,int mes,int ano){

        this.dia = this.getItemDate(dia);
        this.mes = this.getItemDate(mes);
        this.ano = String.valueOf(ano);
    }

    public Data( int ano ){
        this.ano = String.valueOf(ano);
    }

    private String getItemDate(int item){
        String retorno = "";

        if (String.valueOf(item).length() == 1){
            retorno = "0"+String.valueOf(item);
        }else{
            retorno = String.valueOf(item);
        }

        return retorno;
    }

    public String getData(){
        if (mes == null && dia == null){
            return String.format("%s",this.ano);
        }else{
            return String.format("%s/%s/%s",this.dia,this.mes,this.ano);
        }
    }

    public String toString(){
        return this.getData();
    }
}
