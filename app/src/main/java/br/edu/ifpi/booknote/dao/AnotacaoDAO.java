package br.edu.ifpi.booknote.dao;

/*
CREATE TABLE IF NOT EXISTS
    anotacao( id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_capitulo INT,
    titulo VARCHAR(50),
    conteudo VARCHAR(200),
    paginaInicio INT,
    paginaFinal INT);
*/

import java.util.List;

import br.edu.ifpi.booknote.modelo.Anotacao;

public class AnotacaoDAO implements DAO<Anotacao>{

    private DBHelper db;

    public AnotacaoDAO(DBHelper db){
        this.db = db;
    }

    @Override
    public void deletar(Anotacao anotacao) {

        String[] args = {String.valueOf(anotacao.getId())};

        this.db.getWritableDatabase().delete("anotacao", "id = ?", args);

    }

    @Override
    public Anotacao getById(int p) {
        return null;
    }

    @Override
    public List<Anotacao> getAll() {
        return null;
    }
}
