package br.edu.ifpi.booknote.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{

    private final static String DBNAME = "app.db";
    private final static int VERSION = 1;

    private String leitor = "CREATE TABLE IF NOT EXISTS\n" +
            "      leitor(id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "      nome VARCHAR(100),\n" +
            "      idade INTEGER,\n" +
            "      sexo VARCHAR(50));";

    private String leitura = "CREATE TABLE IF NOT EXISTS\n" +
            "    leitura(id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    id_leitor INTEGER,\n" +
            "    id_livro INTEGER,\n" +
            "    avaliacao VARCHAR(50),\n" +
            "    comecoLeitura VARCHAR(50),\n" +
            "    finalLeitura VARCHAR(50));\n" +
            " ";

    private String livro = "CREATE TABLE IF NOT EXISTS\n" +
            "    livro(id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    titulo VARCHAR(100),\n" +
            "    autor VARCHAR(100),\n" +
            "    genero VARCHAR(100),\n" +
            "    anoPublicacao VARCHAR(20),\n" +
            "    quantCapitulos INTEGER,\n" +
            "    tags VARCHAR(200),\n" +
            "    situacao VARCHAR(100));\n";

    private String capitulo = "CREATE TABLE IF NOT EXISTS\n" +
            "    capitulo(id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    id_leitura INTEGER,\n" +
            "    titulo VARCHAR(100));";

    private String anotacao = "CREATE TABLE IF NOT EXISTS\n" +
            "    anotacao( id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    id_capitulo INT,\n" +
            "    titulo VARCHAR(50),\n" +
            "    conteudo VARCHAR(200),\n" +
            "    paginaInicio INT,\n" +
            "    paginaFinal INT);";

    private List<String> querys = Arrays.asList(leitor,livro,leitura,capitulo,anotacao);
    private List<String> tabelas = Arrays.asList("leitor","livro","leitura","capitulo","anotacao");

    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        for(String query : querys){
            db.execSQL(query);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != VERSION){
            for(String tabela : tabelas){
                String drop = "DROP TABLE IF EXISTS "+tabela;

                db.execSQL(drop);
            }
        }


        onCreate(db);

    }

}
