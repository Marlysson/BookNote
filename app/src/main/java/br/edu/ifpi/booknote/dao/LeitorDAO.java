package br.edu.ifpi.booknote.dao;

/*
CREATE TABLE IF NOT EXISTS
      leitor(id INTEGER PRIMARY KEY AUTOINCREMENT,
      nome VARCHAR(100),
      idade INTEGER,
      sexo VARCHAR(50));
*/

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.booknote.modelo.Leitor;

public class LeitorDAO implements DAO<Leitor> {

    private DBHelper db;

    public LeitorDAO(DBHelper db) {
        this.db = db;
    }

    public void inserir(Leitor leitor) {
        ContentValues cv = new ContentValues();

        cv.put("nome", leitor.getNome());
        cv.put("idade",leitor.getIdade());
        cv.put("sexo",leitor.getSexo());

        this.db.getWritableDatabase().insert("leitor", null, cv);

    }


    public void deletar(Leitor leitor) {

        String[] args = {String.valueOf(leitor.getId())};

        this.db.getWritableDatabase().delete("leitor", "id = ?", args);
    }


    public boolean primeiroAcesso(){
        String sql = "SELECT * FROM leitor";

        SQLiteDatabase query = this.db.getReadableDatabase();
        Cursor acesso = query.rawQuery(sql,null);

        if (acesso.getCount() == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getNumUsers(){
        String sql = "SELECT * FROM leitor";
        SQLiteDatabase query = this.db.getReadableDatabase();

        Cursor dados = query.rawQuery(sql,null);

        return dados.getCount();

    }

    public Leitor getById(int id){
        String sql = "SELECT * FROM leitor WHERE id = ?";

        String[] args = {String.valueOf(id)};

        SQLiteDatabase query = this.db.getReadableDatabase();

        Cursor dado = query.rawQuery(sql, args);

        if (dado.getCount() > 0){

            int identif = dado.getInt(dado.getColumnIndex("id"));
            String nome = dado.getString(dado.getColumnIndex("nome"));
            int idade = dado.getInt(dado.getColumnIndex("idade"));
            String sexo = dado.getString(dado.getColumnIndex("sexo"));

            Leitor leitor = new Leitor(nome,idade,sexo);
            leitor.setId(identif);

            return leitor;

        }else{

            return null;
        }
    }

    public List<Leitor> getAll(){
        List<Leitor> leitores = new ArrayList<>();

        String sql = "SELECT * FROM leitor";
        SQLiteDatabase query = this.db.getReadableDatabase();
        Cursor dados = query.rawQuery(sql,null);


        while (dados.moveToNext()){

            int identif = dados.getInt(dados.getColumnIndex("id"));
            String nome = dados.getString(dados.getColumnIndex("nome"));
            int idade = dados.getInt(dados.getColumnIndex("idade"));
            String sexo = dados.getString(dados.getColumnIndex("sexo"));

            Leitor leitor = new Leitor(nome,idade,sexo);
            leitor.setId(identif);

            leitores.add(leitor);
        }

        return leitores;

    }
}
