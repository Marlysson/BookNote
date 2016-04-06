package br.edu.ifpi.booknote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        Button botao = (Button)findViewById(R.id.cadastrar);

        botao.setOnClickListener(new View.OnClickListener() {

            EditText editTitulo = (EditText)findViewById(R.id.titulo);
            EditText editAutor = (EditText)findViewById(R.id.autor);
            Spinner editGenero = (Spinner)findViewById(R.id.genero);
            EditText editAno = (EditText)findViewById(R.id.ano);
            EditText editquantCap = (EditText)findViewById(R.id.quantCapitulos);
            EditText editTags = (EditText)findViewById(R.id.tags);

            String titulo = editTitulo.getText().toString();
            String autor  = editAutor.getText().toString();
            String genero = editGenero.getSelectedItem().toString();
            int ano = Integer.parseInt(editAno.getText().toString());
            int quantCapitulo = Integer.parseInt(editquantCap.getText().toString());
            String tags   = editTags.getText().toString();

            @Override
            public void onClick(View v) {

                if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || ano < 0 || quantCapitulo < 0 || tags.isEmpty()){

                    Toast.makeText(CadastroLivro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

                }else{

                    Livro livro = new Livro(titulo,autor,ano);
                    livro.setGenero(genero);
                    livro.setQuantCapitulos(quantCapitulo);

                    for(String tag : tags.split(",")){
                        livro.addTag(tag);
                    }

                    livroDAO.inserir(livro);

                    Toast.makeText(CadastroLivro.this, livro.getTitulo() + " inserido com sucesso.", Toast.LENGTH_SHORT).show();

                    Intent listagem = new Intent(CadastroLivro.this,ListagemLivros.class);
                    startActivity(listagem);
                }
            }
        });
    }
}
