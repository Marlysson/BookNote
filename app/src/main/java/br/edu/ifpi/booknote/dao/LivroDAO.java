package br.edu.ifpi.booknote.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.edu.ifpi.booknote.enums.Situacao;
import br.edu.ifpi.booknote.modelo.Livro;

/*
CREATE TABLE IF NOT EXISTS
    livro(id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    genero VARCHAR(100),
    anoPublicacao VARCHAR(20),
    quantCapitulos INTEGER,
    tags VARCHAR(200),
    situacao VARCHAR(100));

*/
public class LivroDAO implements DAO<Livro>{

    private final static int VERSAO = 1;
    private DBHelper db;

    public LivroDAO(DBHelper db){
        this.db = db;
    }


    @Override
    public void inserir(Livro livro) {
        ContentValues cv = new ContentValues();

        cv.put("titulo", livro.getTitulo());
        cv.put("autor",livro.getAutor());
        cv.put("genero",livro.getGenero());
        cv.put("anoPublicao",livro.getAnoPublicacao().getData());
        cv.put("quantCapitulos",livro.getQuantCapitulos());
        cv.put("tags",livro.getGenero());
        cv.put("situacao", String.valueOf(Situacao.DESEJADO));

        this.db.getWritableDatabase().insert("leitor", null, cv);

    }

    @Override
    public void deletar(Livro p) {

    }

    @Override
    public Livro getById(int p) {
        return null;
    }

    @Override
    public List<Livro> getAll() {
        String sql = "SELECT * FROM livro";
        SQLiteDatabase query = this.db.getReadableDatabase();

        Cursor dados = query.rawQuery(sql,null);

//
//        while(dados.moveToNext()){
//
//            int id = dados.getInt(dados.getColumnIndex("id"));
//            String titulo = dados.getString(dados.getColumnIndex("titulo"));
//            String situacao = dados.getString(dados.getColumnIndex("situacao"));
//        }
        return null;
    }
}
