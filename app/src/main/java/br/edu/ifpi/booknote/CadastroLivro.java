package br.edu.ifpi.booknote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.edu.ifpi.booknote.dao.DBHelper;
import br.edu.ifpi.booknote.dao.LivroDAO;
import br.edu.ifpi.booknote.modelo.Livro;

public class CadastroLivro extends AppCompatActivity {

    private DBHelper db = new DBHelper(this);
    LivroDAO livroDAO = new LivroDAO(db);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_livro);
        setTitle("Cadastrar Livro");
    }

    public void cadastrarLivro(View view){

        EditText editTitulo = (EditText)findViewById(R.id.titulo);
        EditText editAutor = (EditText)findViewById(R.id.autor);
        Spinner editGenero = (Spinner)findViewById(R.id.genero);
        EditText editAno = (EditText)findViewById(R.id.ano);
        EditText editquantCap = (EditText)findViewById(R.id.quantCapitulos);
        EditText editTags = (EditText)findViewById(R.id.tags);

        if (this.vazio(Arrays.asList(editTitulo,editAutor,editAutor,editGenero,editAno,editquantCap,editTags))){

            Toast.makeText(CadastroLivro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

        }else{

            String titulo = editTitulo.getText().toString();
            String autor  = editAutor.getText().toString();
            String genero = editGenero.getSelectedItem().toString();
            String ano      = editAno.getText().toString();
            String quantCapitulo = editquantCap.toString();
            String tags   = editTags.getText().toString();

            Livro livro = new Livro(titulo,autor,Integer.valueOf(ano));
            livro.setGenero(genero);
            livro.setQuantCapitulos(Integer.valueOf(quantCapitulo));
            
            for(String tag : tags.split(",")){
                 livro.addTag(tag);
            }

            livroDAO.inserir(livro);

            Toast.makeText(CadastroLivro.this, titulo + " inserido com sucesso.", Toast.LENGTH_SHORT).show();

            Intent listagem = new Intent(CadastroLivro.this,ListagemLivros.class);
            startActivity(listagem);
            finish();
        }
    }

    private boolean vazio(List<View> l){

        for(View v : l){
            if (v.toString().length() == 0){
                return true;
            }
        }

        return false;
    }

}
