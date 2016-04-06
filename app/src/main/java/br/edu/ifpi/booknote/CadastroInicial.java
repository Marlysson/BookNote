package br.edu.ifpi.booknote;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.ifpi.booknote.dao.DBHelper;
import br.edu.ifpi.booknote.dao.LeitorDAO;
import br.edu.ifpi.booknote.modelo.Leitor;

public class CadastroInicial extends AppCompatActivity {

    private DBHelper db = new DBHelper(this);
    LeitorDAO leitorDAO = new LeitorDAO(db);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_inicial);
        setTitle("Cadastre-se no BookNote");

        if (leitorDAO.primeiroAcesso()) {

            String boas_vindas = "Com o BookNote você poderá ter total controle sobre as suas leituras.\n\n" +
                    "Nunca mais você se perderá em qual capítulo parou... e ainda poderá avaliá-los.";

            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroInicial.this);
            //View layoutDialog = getLayoutInflater().inflate(R.layout.cadastro_inicial, null);
            //alerta.setView(layoutDialog);
            alerta.setTitle("Bem-Vindo ao BookNote!");
            alerta.setMessage(boas_vindas);

            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alerta.create();
            alerta.show();


        } else {

            String nomes = "";

            for (Leitor l: leitorDAO.getAll()){
                nomes += l.getSexo() + "\n";
            }

            Intent listagem = new Intent(this,ListagemLivros.class);

            startActivity(listagem);
            finish();

        }
    }

    public void inscrever(View botao) {

        EditText editNome = (EditText) findViewById(R.id.nome);
        EditText editIdade = (EditText) findViewById(R.id.idade);
        Spinner editSexo = (Spinner) findViewById(R.id.sexo);

        String nome = editNome.getText().toString();
        int idade = Integer.parseInt(editIdade.getText().toString());
        String sexo = editSexo.getSelectedItem().toString();

        if (nome.isEmpty() || idade < 0 || sexo.isEmpty()){
            Toast.makeText(CadastroInicial.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
        }else{

            Leitor leitor = new Leitor(nome, idade,sexo);

            leitorDAO.inserir(leitor);

            Toast.makeText(CadastroInicial.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent listagem = new Intent(this,ListagemLivros.class);

            startActivity(listagem);
            finish();
        }
    }
}



